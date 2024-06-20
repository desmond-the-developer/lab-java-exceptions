package IronhackJavaLabs.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonsListTest {

    private PersonsList personsList;

    @BeforeEach
    public void setUp() {
        personsList = new PersonsList();
        Person person1 = new Person(1, "Desmond Darville", 35, "Developer");
        Person person2 = new Person(2, "Adrian Maza", 40, "Teacher");
        personsList.addPerson(person1);
        personsList.addPerson(person2);
    }

    @Test
    public void testSetAgeValid() {
        Person person = new Person(3, "Jarko Garrido", 28, "TA");
        person.setAge(35);
        assertEquals(35, person.getAge());
    }

    @Test
    public void testSetAgeInvalid() {
        Person person = new Person(4, "Bob Marley", 40, "Artist");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-5);
        });
    }

    @Test
    public void testFindByNameValid() throws Exception {
        Person foundPerson = personsList.findByName("Desmond Darville");
        assertEquals("Desmond Darville", foundPerson.getName());
    }

    @Test
    public void testFindByNameInvalid() {
        assertThrows(Exception.class, () -> {
            personsList.findByName("Nonexistent Person");
        });
    }

    @Test
    public void testClonePerson() {
        Person originalPerson = new Person(5, "Arnold Schwarzenegger", 62, "Actor");
        Person clonedPerson = personsList.clonePerson(originalPerson);
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());
    }

    public static void main(String[] args) {
        PersonsList personsList = new PersonsList();

        Person person1 = new Person(1, "Desmond Darville", 35, "Developer");
        Person person2 = new Person(2, "Adrian", 40, "Mentor");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        try {
            person1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Test passed: " + e.getMessage());
        }

        try {
            Person foundPerson = personsList.findByName("Desmond Darville");
            System.out.println("Found: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Test failed: " + e.getMessage());
        }

        try {
            Person clonedPerson = personsList.clonePerson(person1);
            System.out.println("Cloned person: " + clonedPerson);
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }

        System.out.println("All tests completed.");
    }
}

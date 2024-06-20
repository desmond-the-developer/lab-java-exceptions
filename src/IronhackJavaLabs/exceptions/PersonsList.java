package IronhackJavaLabs.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) throws IllegalArgumentException {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("No person found with the name: " + name);
    }

    public Person clonePerson(Person person) {
        return new Person(person.getId() + 1, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writeToFile(Person person) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(person.getName() + ".txt"))) {
            writer.println(person);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
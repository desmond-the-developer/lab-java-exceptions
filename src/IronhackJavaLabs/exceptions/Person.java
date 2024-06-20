package IronhackJavaLabs.exceptions;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id; // Initialize id property
        this.name = name; // Initialize name property
        this.age = age; // Initialize age property
        this.occupation = occupation; // Initialize occupation property
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0"); // Throw error if age is less than 0
        }
        this.age = age; // Set age property
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the objects are the same
        if (obj == null || getClass() != obj.getClass()) return false; // Check if the classes are different
        Person person = (Person) obj;
        return name.equals(person.name) && age == person.age && occupation.equals(person.occupation); // Compare properties excluding id
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}


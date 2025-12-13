package Classes;

import Enums.Gender;
import Enums.Location;
import Interfaces.Human;

import java.time.LocalDate;

public abstract class Person implements Human {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private Location location;

    protected static int counter = 0;

    {
        firstName = "Unknown";
        lastName = "Unknown";
        age = 0;
        gender = Gender.MALE;
        location = Location.ZHYTOMYR;
        counter++;
    }

    public Person() {}

    public Person(String firstName, String lastName, int age, Gender gender, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract void getOccupation();

    public String getFullInfo() {
        return String.format("%s %s, %d years old, %s, from %s", firstName, lastName, age, gender, location);
    }

    @Override
    public void sayFullName () {
        System.out.println(String.format("%s %s", firstName, lastName));
    }

    @Override
    public void sayAge() {
        System.out.println(String.format("Age: %s", age));
    }

    @Override
    public void sayGender() {
        System.out.println(String.format("Gender: %s", gender));
    }

    @Override
    public void sayLocation() {
        System.out.println(String.format("Location: %s", location));
    }

    public static void showCounter() {
        System.out.println(String.format("Total Persons created: %d", counter));
    }
}

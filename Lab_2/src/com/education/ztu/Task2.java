package com.education.ztu;
interface Human {
    void sayFullName();
    void sayAge();
    void sayLocation();
    void sayGender();
    default void whoIAm() {
        System.out.println("I am a human!");
    }
}
enum Location { KYIV, LVIV, ODESSA, KHARKIV, OTHER }
enum Gender { MALE, FEMALE, OTHER }
abstract class Person implements Human {
    private String firstName;
    private String lastName;
    protected int age;
    protected Location location;
    protected Gender gender;
    private static int counter;
    {
        firstName = "Unknown";
        lastName = "Unknown";
        age = 0;
        location = Location.OTHER;
        gender = Gender.OTHER;
        counter++;
    }
    public Person() {}
    public Person(String firstName, String lastName, int age, Location location, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.gender = gender;
        counter++;
    }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    @Override
    public void sayFullName() {
        System.out.println("Full name: " + firstName + " " + lastName);
    }
    @Override
    public void sayAge() {
        System.out.println("Age: " + age);
    }
    @Override
    public void sayLocation() {
        System.out.println("Location: " + location);
    }
    @Override
    public void sayGender() {
        System.out.println("Gender: " + gender);
    }
    public abstract String getOccupation();
    public void getFullInfo() {
        sayFullName();
        sayAge();
        sayLocation();
        sayGender();
        System.out.println("Occupation: " + getOccupation());
    }
    public static void showCounter() {
        System.out.println("Created persons: " + counter);
    }
}
class Student extends Person {
    private String university;
    public Student() {
        super();
        this.university = "Unknown University";
    }
    public Student(String firstName, String lastName, int age, Location location, Gender gender, String university) {
        super(firstName, lastName, age, location, gender);
        this.university = university;
    }
    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }
    @Override
    public String getOccupation() {
        return "Student at " + university;
    }
}
class Car {
    private String model;
    private Engine engine;
    public Car(String model) {
        this.model = model;
        this.engine = new Engine();
    }
    public String getModel() { return model; }
    public void startCar() { engine.startEngine(); }
    public void stopCar() { engine.stopEngine(); }
    public boolean isRunning() { return engine.isEngineWorks(); }
    class Engine {
        private boolean running;
        public void startEngine() {
            running = true;
            System.out.println("Engine started!");
        }
        public void stopEngine() {
            running = false;
            System.out.println("Engine stopped!");
        }
        public boolean isEngineWorks() {
            return running;
        }
    }
}
class Teacher extends Person {
    private String subject;
    private Car car;
    public Teacher() {
        super();
        this.subject = "Unknown subject";
        this.car = new Car("Default Car");
    }
    public Teacher(String firstName, String lastName, int age, Location location, Gender gender, String subject, Car car) {
        super(firstName, lastName, age, location, gender);
        this.subject = subject;
        this.car = car;
    }
    @Override
    public String getOccupation() {
        return "Teacher of " + subject;
    }
    public Car getCar() { return car; }
}
class Employee extends Person {
    private String position;
    private Car car;
    public Employee() {
        super();
        this.position = "Unemployed";
        this.car = new Car("Default Car");
    }
    public Employee(String firstName, String lastName, int age, Location location, Gender gender, String position, Car car) {
        super(firstName, lastName, age, location, gender);
        this.position = position;
        this.car = car;
    }
    @Override
    public String getOccupation() {
        return "Employee, position: " + position;
    }
    public Car getCar() { return car; }
}

public class Task2 {
    public static void main(String[] args) {
        Student s = new Student("Ivan", "Petrenko", 20, Location.KYIV, Gender.MALE, "ZTU");
        Teacher t = new Teacher("Olena", "Koval", 40, Location.LVIV, Gender.FEMALE, "Math", new Car("Toyota"));
        Employee e = new Employee("Andrii", "Shevchenko", 35, Location.ODESSA, Gender.MALE, "Manager", new Car("BMW"));
        System.out.println("=== Student ===");
        s.getFullInfo();
        System.out.println("\n=== Teacher ===");
        t.getFullInfo();
        t.getCar().startCar();
        System.out.println("Is car running? " + t.getCar().isRunning());
        t.getCar().stopCar();
        System.out.println("\n=== Employee ===");
        e.getFullInfo();
        System.out.println("\n--- instanceof demo ---");
        System.out.println("s instanceof Student: " + (s instanceof Student));
        System.out.println("t instanceof Person: " + (t instanceof Person));
        System.out.println("e instanceof Human: " + (e instanceof Human));
        Person.showCounter();
    }
}
package Classes;

import Enums.Gender;
import Enums.Location;

public class Teacher extends Person {
    private String subject;
    private String university;
    private Car car;

    public Teacher() {}

    public Teacher(String firstName, String lastName, int age, Gender gender, Location location, String subject, String university, Car car) {
        super(firstName, lastName, age, gender, location);
        this.subject = subject;
        this.university = university;
        this.car = car;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubjects(String subject) {
        this.subject = subject;
    }
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void getOccupation() {
        System.out.println("Occupation: Teacher");
    }
}

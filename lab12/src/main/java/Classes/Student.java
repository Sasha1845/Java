package Classes;

import Enums.Gender;
import Enums.Location;

public class Student extends Person {
    private int course;
    private String specialty;
    private String university;

    public Student () {}
    public Student (String firstName, String lastName, int age, Gender gender, Location location, int course, String specialty, String university) {
        super (firstName, lastName, age, gender, location);
    this.course = course;
    this.specialty = specialty;
    this.university = university;
    }
    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void getOccupation() {
        System.out.println("Occupation: Student");
    }
}

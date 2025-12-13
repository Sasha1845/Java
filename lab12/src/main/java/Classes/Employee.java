package Classes;

import Enums.Gender;
import Enums.Location;

public class Employee extends Person {
    private String company;
    private String position;
    private Car car;

    public Employee() {}

    public Employee(String firstName, String lastName, int age, Gender gender, Location location, String company, String position, Car car) {
        super(firstName, lastName, age, gender, location);
        this.company = company;
        this.position = position;
        this.car = car;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void getOccupation() {
        System.out.println("Occupation: Employee");
    }
}

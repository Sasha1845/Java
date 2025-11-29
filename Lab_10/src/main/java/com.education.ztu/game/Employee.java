/**
 * Represents an Employee who is also a Participant in the game.
 * This class extends the Participant class, inheriting its properties and behavior.
 */
package com.education.ztu.game;

public class Employee extends Participant {

    /**
     * Constructs an Employee object with a specified name and age.
     *
     * @param name the name of the employee
     * @param age  the age of the employee
     */
    public Employee(String name, int age) {
        super(name, age);
    }
}


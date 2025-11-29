/**
 * Represents a Student participant in the game, extending the Participant class.
 * Inherits the name and age properties from the Participant class.
 */
package com.education.ztu.game;

public class Student extends Participant {

    /**
     * Constructs a Student object with a specified name and age.
     * This constructor calls the constructor of the Participant class.
     *
     * @param name the name of the Student
     * @param age  the age of the Student
     */
    public Student(String name, int age) {
        super(name, age);
    }
}

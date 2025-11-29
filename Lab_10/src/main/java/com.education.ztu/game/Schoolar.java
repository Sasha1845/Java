/**
 * Represents a Schoolar participant in the game, extending the Participant class.
 * Inherits the name and age properties from the Participant class.
 */
package com.education.ztu.game;

public class Schoolar extends Participant {

    public Schoolar() {
    }
    /**
     * Constructs a Schoolar object with a specified name and age.
     * This constructor calls the constructor of the Participant class.
     *
     * @param name the name of the Schoolar
     * @param age  the age of the Schoolar
     */
    public Schoolar(String name, int age) {
        super(name, age);  // Викликає конструктор батьківського класу Participant
    }
}



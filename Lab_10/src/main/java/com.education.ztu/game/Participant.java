/**
 * Represents a participant in the game with a name and age.
 * This class implements Cloneable to allow object cloning and Comparable for natural sorting by name.
 * Subclasses should provide specific behavior for participants in the game.
 */
package com.education.ztu.game;

public abstract class Participant implements Cloneable, Comparable<Participant> {
    private String name;  // Name of the participant
    private int age;      // Age of the participant
    public Participant() {

    }
    /**
     * Constructs a Participant object with a specified name and age.
     *
     * @param name the name of the participant
     * @param age  the age of the participant
     */
    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the participant.
     *
     * @return the name of the participant
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the participant.
     *
     * @return the age of the participant
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the name of the participant.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the age of the participant.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Compares this participant to another participant based on their name.
     * The comparison is lexicographical based on the participant's name.
     *
     * @param other the other participant to compare to
     * @return a negative integer, zero, or a positive integer if this participant's name is less than, equal to, or greater than the other's name
     */
    @Override
    public int compareTo(Participant other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Creates and returns a clone of this participant.
     *
     * @return a clone of this participant
     * @throws AssertionError if cloning is not supported
     */
    @Override
    public Participant clone() {
        try {
            return (Participant) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported");
        }
    }

    /**
     * Determines if this participant is equal to another object.
     * Two participants are considered equal if their names and ages are the same.
     *
     * @param obj the object to compare to
     * @return true if the participants are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Participant that = (Participant) obj;
        return age == that.age && name.equals(that.name);
    }

    /**
     * Returns the hash code of this participant.
     * The hash code is generated based on the participant's name and age.
     *
     * @return the hash code of this participant
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    /**
     * Returns a string representation of the participant, including their name and age.
     *
     * @return a string representation of the participant
     */
    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + "}";
    }
}

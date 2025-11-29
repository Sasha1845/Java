/**
 * Represents a team of participants in the game, with a generic type that extends Participant.
 * This class allows adding participants, playing against another team, and provides methods for comparing, cloning, and displaying team information.
 */
package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;                          // Name of the team
    private List<T> participants = new ArrayList<>(); // List of participants in the team

    /**
     * Constructs a Team object with the specified name.
     *
     * @param name the name of the team
     */
    public Team(String name) {
        this.name = name;
    }

    /**
     * Constructs a Team object by copying another team, cloning its participants.
     *
     * @param other the team to clone
     */
    public Team(Team<T> other) {
        this.name = other.name;
        for (T participant : other.participants) {
            this.participants.add((T) participant.clone()); // Cloning participants to ensure they are distinct objects
        }
    }

    /**
     * Simulates a game between this team and another team, randomly selecting a winner.
     *
     * @param team the other team to play against
     */
    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2); // Randomly selects 0 or 1
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("The team " + winnerName + " is the winner!"); // Prints the winner's name
    }

    /**
     * Adds a new participant to the team.
     *
     * @param participant the participant to add
     */
    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("Participant " + participant.getName() + " added to the team " + name); // Prints confirmation message
    }

    /**
     * Returns the name of the team.
     *
     * @return the name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of participants in the team.
     *
     * @return the list of participants
     */
    public List<T> getParticipants() {
        return participants;
    }

    /**
     * Returns a hash code for this team, based on its name and participants list.
     *
     * @return the hash code for this team
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + participants.hashCode();
        return result;
    }

    /**
     * Determines if this team is equal to another team.
     * Teams are considered equal if their names and participants are the same.
     *
     * @param obj the object to compare to
     * @return true if the teams are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Team<?> team = (Team<?>) obj;
        return name.equals(team.name) && participants.equals(team.participants);
    }

    /**
     * Returns a string representation of the team, including its name and participants.
     *
     * @return a string representing the team
     */
    @Override
    public String toString() {
        return "Team{name='" + name + "', participants=" + participants + "}";
    }
}
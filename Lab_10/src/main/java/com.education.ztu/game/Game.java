/**
 * Demonstrates the creation and management of teams in a game,
 * with participants categorized as Scholars, Students, or Employees.
 * This program showcases how teams can be created, participants added, and competitions held.
 */
package com.education.ztu.game;

public class Game {

    /**
     * The entry point of the application.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Creating Scholar participants
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);

        // Creating Student participants
        Student student1 = new Student("Mykola", 20);
        Student student2 = new Student("Viktoria", 21);

        // Creating Employee participants
        Employee employee1 = new Employee("Andriy", 28);
        Employee employee2 = new Employee("Oksana", 25);

        // Creating and populating a team of Scholars
        Team<Schoolar> scollarTeam = new Team<>("Dragon");
        scollarTeam.addNewParticipant(schoolar1);
        scollarTeam.addNewParticipant(schoolar2);

        // Creating and populating a team of Students
        Team<Student> studentTeam = new Team<>("Vpered");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        // Creating and populating a team of Employees
        Team<Employee> employeeTeam = new Team<>("Robotyagi");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        // Creating a second team of Scholars and adding participants
        Team<Schoolar> scollarTeam2 = new Team<>("Rozumnyky");
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olga", 14);
        scollarTeam2.addNewParticipant(schoolar3);
        scollarTeam2.addNewParticipant(schoolar4);

        // Initiating a competition between two teams of Scholars
        scollarTeam.playWith(scollarTeam2);
    }
}


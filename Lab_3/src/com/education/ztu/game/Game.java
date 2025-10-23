package com.education.ztu.game;

public class Game {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Dennis", 12);
        Schoolar schoolar2 = new Schoolar("Victoria", 14);
        Schoolar schoolar3 = new Schoolar("Robert", 11);
        Schoolar schoolar4 = new Schoolar("Alina", 13);

        Student student1 = new Student("Oliver", 19);
        Student student2 = new Student("Diana", 20);
        Student student3 = new Student("Eugene", 21);
        Student student4 = new Student("Marina", 18);

        Employee employee1 = new Employee("Gregory", 27);
        Employee employee2 = new Employee("Tatiana", 24);
        Employee employee3 = new Employee("Sergio", 29);
        Employee employee4 = new Employee("Lydia", 26);

        System.out.println("=== Creating Schoolar Teams ===");
        Team<Schoolar> schoolarTeam1 = new Team<>("Stars");
        schoolarTeam1.addNewParticipant(schoolar1);
        schoolarTeam1.addNewParticipant(schoolar2);

        Team<Schoolar> schoolarTeam2 = new Team<>("Winners");
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);

        System.out.println("\n=== Creating Student Teams ===");
        Team<Student> studentTeam1 = new Team<>("Intellectuals");
        studentTeam1.addNewParticipant(student1);
        studentTeam1.addNewParticipant(student2);

        Team<Student> studentTeam2 = new Team<>("Brilliant");
        studentTeam2.addNewParticipant(student3);
        studentTeam2.addNewParticipant(student4);

        System.out.println("\n=== Creating Employee Teams ===");
        Team<Employee> employeeTeam1 = new Team<>("Professionals");
        employeeTeam1.addNewParticipant(employee1);
        employeeTeam1.addNewParticipant(employee2);

        Team<Employee> employeeTeam2 = new Team<>("Masters");
        employeeTeam2.addNewParticipant(employee3);
        employeeTeam2.addNewParticipant(employee4);

        System.out.println("\n=== Games ===");
        System.out.println("Schoolar teams playing:");
        schoolarTeam1.playWith(schoolarTeam2);

        System.out.println("\nStudent teams playing:");
        studentTeam1.playWith(studentTeam2);

        System.out.println("\nEmployee teams playing:");
        employeeTeam1.playWith(employeeTeam2);
    }
}
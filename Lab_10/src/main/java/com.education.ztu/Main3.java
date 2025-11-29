package com.education.ztu;

import com.education.ztu.Classes.XMLReader;
import com.education.ztu.Classes.XMLWriter;
import com.education.ztu.game.Student;

public class Main3 {

    public static void main(String[] args) {

        Student[] students = {
                new Student("Mark Spencer", 23),
                new Student("Emily Johnson", 24)
        };

        XMLWriter.writeStudents("data/students.xml", students);

        String filePath = "data/students.xml";

        Student[] readStudents = XMLReader.readStudents(filePath);

        if (readStudents != null) {
            for (Student student : readStudents) {
                System.out.println("Name: " + student.getName() + ", Age: " + student.getAge());
            }
        } else {
            System.out.println("Не вдалося зчитати студентів.");
        }
    }
}
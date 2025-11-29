package com.education.ztu.Classes;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import com.education.ztu.game.Student;

public class XMLReader {
    public static Student[] readStudents(String filePath) {
        try {
            File file = new File(filePath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList studentList = doc.getElementsByTagName("student");
            Student[] students = new Student[studentList.getLength()];

            for (int i = 0; i < studentList.getLength(); i++) {
                Node node = studentList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) node;

                    String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                    int age = Integer.parseInt(studentElement.getElementsByTagName("age").item(0).getTextContent());

                    students[i] = new Student(name, age);
                }
            }

            return students;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


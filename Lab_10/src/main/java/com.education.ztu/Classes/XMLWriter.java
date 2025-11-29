package com.education.ztu.Classes;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import com.education.ztu.game.Student;

public class XMLWriter {
    public static void writeStudents(String filePath, Student[] students) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement = doc.createElement("students");
            doc.appendChild(rootElement);

            for (Student student : students) {
                Element studentElement = doc.createElement("student");
                rootElement.appendChild(studentElement);

                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(student.getName()));
                studentElement.appendChild(name);

                Element age = doc.createElement("age");
                age.appendChild(doc.createTextNode(String.valueOf(student.getAge())));
                studentElement.appendChild(age);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);

            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdir();
            }

            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            System.out.println("XML файл успішно збережено в папку 'data'!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
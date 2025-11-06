package com.education.ztu;

import java.io.*;
import java.util.List;

public class PurchaseReport {
    public static void writeReport(String filename, List<String> items) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (String item : items) {
                writer.write(item + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readReport(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char)c);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

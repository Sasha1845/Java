package com.education.ztu;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String baseDir = "directory_for_files";

        // ===== Завдання 2: Перевірка логіну та паролю =====
        System.out.println("=== Check credentials ===");
        boolean valid = checkCredentials("User_123", "Pass_123", "Pass_123");
        System.out.println("Credentials valid: " + valid);

        // ===== Завдання 3: Звіт про покупки =====
        List<String> cart = Arrays.asList("Apple - 2 pcs", "Banana - 3 pcs", "Milk - 1 L");
        String reportFile = baseDir + "/purchase_report.txt";
        PurchaseReport.writeReport(reportFile, cart);
        System.out.println("\nPurchase report written. Reading:");
        PurchaseReport.readReport(reportFile);

        // ===== Завдання 4: Копіювання файлів =====
        String copyText = baseDir + "/report_copy.txt";
        FileCopyUtil.copyTextFile(reportFile, copyText);

        // ===== Завдання 5: RandomAccessFile =====
        try (RandomAccessFile raf = new RandomAccessFile(reportFile, "rw")) {
            raf.seek(raf.length());
            raf.writeBytes("Eggs - 12 pcs\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== Завдання 6: Робота з File =====
        File innerDir = new File(baseDir + "/inner_directory");
        innerDir.mkdir();
        System.out.println("\nAbsolute path: " + innerDir.getAbsolutePath());
        System.out.println("Parent: " + innerDir.getParent());

        File file1 = new File(innerDir, "file1.txt");
        File file2 = new File(innerDir, "file2.txt");
        file1.createNewFile();
        file2.createNewFile();

        file1.delete();
        innerDir.renameTo(new File(baseDir + "/renamed_inner_directory"));

        System.out.println("\nFiles in directory_for_files:");
        File[] files = new File(baseDir).listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName() + " - " + f.length() + " bytes - " + (f.isDirectory() ? "folder" : "file"));
            }
        }

        // ===== Завдання 7: Архівування =====
        String zipFile = baseDir + "/archive.zip";
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
            for (File f : new File(baseDir).listFiles()) {
                if (f.isFile()) {
                    try (FileInputStream fis = new FileInputStream(f)) {
                        zos.putNextEntry(new ZipEntry(f.getName()));
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = fis.read(buffer)) > 0) {
                            zos.write(buffer, 0, len);
                        }
                        zos.closeEntry();
                    }
                }
            }
        }

        System.out.println("\nFiles in ZIP archive:");
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    // ===== Метод перевірки логіну та паролю =====
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20)
                throw new WrongLoginException("Login must contain only letters, digits, '_' and less than 20 chars.");
            if (!password.matches("[A-Za-z0-9_]+") || password.length() >= 20 ||
                    !password.equals(confirmPassword))
                throw new WrongPasswordException("Password invalid or does not match confirmPassword.");
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}

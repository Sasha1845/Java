package com.education.ztu;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Task_5 {
    public static void main(String[] args) {
        System.out.println("\n\n");
        System.out.println("╔═════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         ДЕМОНСТРАЦІЯ ІНТЕРНАЦІОНАЛІЗАЦІЇ КАСОВИХ ЧЕКІВ             ║");
        System.out.println("║              Internationalization Demo - Receipts                   ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        Locale ukraineLocale = new Locale("uk", "UA");
        Locale usLocale = new Locale("en", "US");
        Locale germanyLocale = new Locale("de", "DE");

        try {
            printReceipt(ukraineLocale);
            System.out.println("\n\n");

            printReceipt(usLocale);
            System.out.println("\n\n");

            printReceipt(germanyLocale);
            System.out.println("\n");

        } catch (Exception e) {
            System.err.println("╔═════════════════════════════════════════════════════════════════════╗");
            System.err.println("║                          ПОМИЛКА / ERROR                            ║");
            System.err.println("╚═════════════════════════════════════════════════════════════════════╝");
            System.err.println();
            System.err.println("Не вдалося завантажити файли ресурсів!");
            System.err.println("Failed to load resource files!");
            System.err.println("Ressourcendateien konnten nicht geladen werden!");
            System.err.println();
            System.err.println("Переконайтеся, що файли знаходяться у директорії:");
            System.err.println("Make sure files are located in directory:");
            System.err.println("- src/com/education/ztu/data_uk_UA.properties");
            System.err.println("- src/com/education/ztu/data_en_US.properties");
            System.err.println("- src/com/education/ztu/data_de_DE.properties");
            System.err.println();
            System.err.println("Деталі помилки / Error details:");
            e.printStackTrace();
        }
    }

    public static void printReceipt(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("com.education.ztu.data", locale);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", locale);

        String currentDateTime = dateFormat.format(new Date());

        double subtotal = 0.0;

        for (int i = 1; i <= 10; i++) {
            double price = Double.parseDouble(bundle.getString("product" + i + ".price"));
            subtotal += price;
        }

        double taxRate = 0.20;
        double taxAmount = subtotal * taxRate;
        double totalAmount = subtotal + taxAmount;

        System.out.println("╔═════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║  %-65s  ║%n", bundle.getString("receipt.store"));
        System.out.printf("║  %-65s  ║%n", bundle.getString("receipt.address"));
        System.out.printf("║  %-65s  ║%n", bundle.getString("receipt.phone"));
        System.out.println("╠═════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║%26s%-43s║%n", "", bundle.getString("receipt.title"));
        System.out.println("╠═════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║  %-22s %-42s ║%n", bundle.getString("receipt.datetime") + ":", currentDateTime);
        System.out.println("╠═════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-4s %-20s %-22s %14s ║%n",
                bundle.getString("receipt.number"),
                bundle.getString("receipt.item"),
                bundle.getString("receipt.category"),
                bundle.getString("receipt.price"));
        System.out.println("╠═════════════════════════════════════════════════════════════════════╣");

        for (int i = 1; i <= 10; i++) {
            String itemName = bundle.getString("product" + i + ".name");
            String itemCategory = bundle.getString("product" + i + ".category");
            double itemPrice = Double.parseDouble(bundle.getString("product" + i + ".price"));

            System.out.printf("║ %-4s %-20s %-22s %14s ║%n",
                    i + ".",
                    truncateString(itemName, 20),
                    truncateString(itemCategory, 22),
                    currencyFormat.format(itemPrice));
        }

        System.out.println("╠═════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-49s %14s ║%n",
                bundle.getString("receipt.subtotal") + ":",
                currencyFormat.format(subtotal));
        System.out.printf("║ %-49s %14s ║%n",
                bundle.getString("receipt.tax") + ":",
                currencyFormat.format(taxAmount));
        System.out.println("╠═════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-49s %14s ║%n",
                bundle.getString("receipt.total") + ":",
                currencyFormat.format(totalAmount));
        System.out.println("╠═════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║%28s%-41s║%n", "", bundle.getString("receipt.thanks"));
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
    }

    private static String truncateString(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }
}
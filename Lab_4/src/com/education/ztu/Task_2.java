package com.education.ztu;

public class Task_2 {
    public static void main(String[] args) {
        processString("Hello World! I study Programming!!!");
    }

    public static void processString(String str) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║           ЗАВДАННЯ 2: Практика методів String             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("➤ Вихідний рядок: \"" + str + "\"");
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 1. Останній символ рядка                                   │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.println("   Результат: '" + str.charAt(str.length() - 1) + "'");
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 2. Перевірка: чи закінчується рядок на '!!!'              │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.println("   Результат: " + str.endsWith("!!!"));
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 3. Перевірка: чи починається рядок з 'Hello '             │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.println("   Результат: " + str.startsWith("Hello "));
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 4. Перевірка: чи містить рядок 'Programming'              │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.println("   Результат: " + str.contains("Programming"));
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 5. Позиція підрядка 'Programming'                         │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.println("   Результат: індекс = " + str.indexOf("Programming"));
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 6. Заміна всіх 'o' на 'a'                                 │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.println("   Результат: \"" + str.replace('o', 'a') + "\"");
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 7. Перетворення на верхній регістр                        │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.println("   Результат: \"" + str.toUpperCase() + "\"");
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 8. Перетворення на нижній регістр                         │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.println("   Результат: \"" + str.toLowerCase() + "\"");
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 9. Вирізати підрядок 'Programming'                        │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        int start = str.indexOf("Programming");
        System.out.println("   Результат: \"" + str.substring(start, start + "Programming".length()) + "\"");
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                   Завдання виконано!                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}
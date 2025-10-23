package com.education.ztu;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║         ЗАВДАННЯ 3: Робота зі StringBuilder                ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.print("➤ Введіть перше число: ");
        int a = scanner.nextInt();

        System.out.print("➤ Введіть друге число: ");
        int b = scanner.nextInt();
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 1. Створення рядків з операціями (метод append)           │");
        System.out.println("└────────────────────────────────────────────────────────────┘");

        StringBuilder sb1 = new StringBuilder();
        sb1.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println("   ✓ Додавання: " + sb1);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(a).append(" - ").append(b).append(" = ").append(a - b);
        System.out.println("   ✓ Віднімання: " + sb2);

        StringBuilder sb3 = new StringBuilder();
        sb3.append(a).append(" * ").append(b).append(" = ").append(a * b);
        System.out.println("   ✓ Множення: " + sb3);
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 2. Заміна '=' на 'дорівнює' (insert + deleteCharAt)       │");
        System.out.println("└────────────────────────────────────────────────────────────┘");

        StringBuilder sb4 = new StringBuilder();
        sb4.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println("   Початковий рядок: " + sb4);

        int index = sb4.indexOf("=");
        sb4.deleteCharAt(index);
        sb4.insert(index, "дорівнює");
        System.out.println("   Після заміни:     " + sb4);
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 3. Заміна '=' на 'дорівнює' (метод replace)               │");
        System.out.println("└────────────────────────────────────────────────────────────┘");

        StringBuilder sb5 = new StringBuilder();
        sb5.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println("   Початковий рядок: " + sb5);

        int startIndex = sb5.indexOf("=");
        sb5.replace(startIndex, startIndex + 1, "дорівнює");
        System.out.println("   Після заміни:     " + sb5);
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 4. Реверс рядка (метод reverse)                           │");
        System.out.println("└────────────────────────────────────────────────────────────┘");

        StringBuilder sb6 = new StringBuilder();
        sb6.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println("   Оригінал:  " + sb6);
        sb6.reverse();
        System.out.println("   Реверс:    " + sb6);
        System.out.println();

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│ 5. Довжина (length) та ємність (capacity)                 │");
        System.out.println("└────────────────────────────────────────────────────────────┘");

        StringBuilder sb7 = new StringBuilder();
        sb7.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println("   Рядок:           " + sb7);
        System.out.println("   length():        " + sb7.length() + " символів");
        System.out.println("   capacity():      " + sb7.capacity() + " символів");
        System.out.println();

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                   Завдання виконано!                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        scanner.close();
    }
}
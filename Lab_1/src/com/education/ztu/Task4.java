package com.education.ztu;
import java.util.Scanner;
public class Task4 {
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть перше додатне число: ");
        int x = scanner.nextInt();
        System.out.print("Введіть друге додатне число: ");
        int y = scanner.nextInt();
        if (x <= 0 || y <= 0) {
            System.out.println("Числа повинні бути додатними!");
        } else {
            System.out.println("НСД = " + gcd(x, y));
        }
        scanner.close();
    }
}

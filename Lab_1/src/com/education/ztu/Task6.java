package com.education.ztu;
import java.util.Scanner;
public class Task6 {
    private static int[] fibonacciArray(int n) {
        int[] arr = new int[n];
        if (n > 0) arr[0] = 1;
        if (n > 1) arr[1] = 11;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    private static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = arr[n - 1 - i];
        }
        return reversed;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість елементів n: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("n повинно бути додатним!");
        } else {
            int[] fib = fibonacciArray(n);
            int[] reversed = reverseArray(fib);
            System.out.print("Масив Фібоначчі: ");
            printArray(fib);
            System.out.print("Зворотний масив: ");
            printArray(reversed);
        }
        scanner.close();
    }
}

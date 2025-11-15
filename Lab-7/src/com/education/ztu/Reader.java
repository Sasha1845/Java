package com.education.ztu;

import java.util.Scanner;

public class Reader implements Runnable {
    private final SharedData sharedData;
    private final Scanner scanner;

    public Reader(SharedData sharedData, Scanner scanner) {
        this.sharedData = sharedData;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.println("Reader почав роботу. Введіть 'exit' для завершення.");

        synchronized (sharedData.lock) {
            while (true) {
                while (sharedData.isDataAvailable()) {
                    try {
                        System.out.println("[Reader] - Очікування, поки Printer використає дані...");
                        sharedData.lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                System.out.print("Введіть рядок: ");
                String input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input)) {
                    sharedData.setData(input); // Повідомляємо про вихід
                    sharedData.lock.notifyAll(); // Будимо Printer
                    break;
                }

                sharedData.setData(input);

                sharedData.lock.notifyAll();

                try {
                    System.out.println("[Reader] - Засинаю на 1 секунду...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
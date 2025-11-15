package com.education.ztu;

public class MyProgressor implements Runnable {
    private static int result = 1;

    @Override
    public void run() {
        printAndAddSynchronized();
    }
    public static synchronized void printAndAddSynchronized() {
        while (result <= 100) {
            System.out.print(Thread.currentThread().getName() + ": " + result + " ");
            result += 1;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("\n" + Thread.currentThread().getName() + " завершив роботу.");
    }
}
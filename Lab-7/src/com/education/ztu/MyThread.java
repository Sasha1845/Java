package com.education.ztu;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
        System.out.println("--- Завдання 2 ---");
        System.out.println("Потік " + this.getName() + " створено. Стан: " + this.getState()); // NEW
    }

    @Override
    public void run() {
        System.out.println("Потік " + this.getName() + " почав роботу. Стан: " + this.getState()); // RUNNABLE/RUNNING

        for (int i = 0; i < 100; i++) {
            System.out.println("Я люблю програмувати!!! (потік " + this.getName() + ")");
            if (i == 50 && Thread.currentThread().isInterrupted()) {
                System.out.println("Потік " + this.getName() + " перервано.");
                break;
            }
        }

        System.out.println("Потік " + this.getName() + " завершив роботу.");
    }
}
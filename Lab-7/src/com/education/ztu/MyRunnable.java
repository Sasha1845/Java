package com.education.ztu;

public class MyRunnable implements Runnable {
    private final String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + ": Початок розрахунку.");
        try {
            for (int i = 0; i <= 10000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }

                if (i % 10 == 0) {
                    System.out.println(name + ": " + i);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("\n*** " + name + ": Розрахунок завершено!!! ***");
            return;
        }
        System.out.println(name + ": Розрахунок завершено (без interrupt).");
    }
}
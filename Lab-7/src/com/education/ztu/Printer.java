package com.education.ztu;

public class Printer implements Runnable {
    private final SharedData sharedData;

    public Printer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        System.out.println("Printer почав роботу.");

        synchronized (sharedData.lock) {
            while (true) {
                while (!sharedData.isDataAvailable()) {
                    try {
                        System.out.println("[Printer] - Очікування нових даних...");
                        sharedData.lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                String data = sharedData.getData();

                if ("exit".equalsIgnoreCase(data)) {
                    System.out.println("[Printer] - Отримано команду 'exit'. Завершення роботи.");
                    sharedData.lock.notifyAll(); // Будимо Reader, щоб він теж завершив роботу
                    break;
                }

                System.out.println("\n*** [Printer] Отриманий рядок: " + data + " ***");

                sharedData.consumeData();
                sharedData.lock.notifyAll();
            }
        }
    }
}
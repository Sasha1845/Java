package com.education.ztu;

import java.util.concurrent.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        task2();
        task3();
        task4_5();
        task6();
        task7();
    }

    private static void task2() throws InterruptedException {
        System.out.println("*** Завдання 2: Thread ***");

        MyThread myThread = new MyThread("Custom-Thread-1");

        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріоритет: " + myThread.getPriority());
        System.out.println("Чи живий? " + myThread.isAlive());
        System.out.println("Чи демон? " + myThread.isDaemon());

        myThread.setName("New-Custom-Thread-Processor");
        myThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Оновлена інформація:");
        System.out.println("Нове ім'я потоку: " + myThread.getName());
        System.out.println("Новий пріоритет: " + myThread.getPriority());

        myThread.start();

        myThread.join();

        System.out.println("Потік " + myThread.getName() + " завершив роботу. Стан: " + myThread.getState());

        Thread mainThread = Thread.currentThread();
        System.out.println("Інформація про головний потік:");
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());
        System.out.println("Стан головного потоку: " + mainThread.getState());

        System.out.println("-------------------------");
    }

    private static void task3() throws InterruptedException {
        System.out.println("\n*** Завдання 3: Runnable (interrupt) ***");

        Thread t1 = new Thread(new MyRunnable("Runner-1"), "T3-1");
        Thread t2 = new Thread(new MyRunnable("Runner-2"), "T3-2");
        Thread t3 = new Thread(new MyRunnable("Runner-3"), "T3-3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Головний потік чекає 2 секунди...");
        Thread.sleep(2000);

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("-------------------------");
    }

    private static void task4_5() throws InterruptedException {
        System.out.println("\n*** Завдання 4 & 5: Арифметична прогресія (Синхронізація) ***");

        Thread t4_1 = new Thread(new MyProgressor(), "P-T1");
        Thread t4_2 = new Thread(new MyProgressor(), "P-T2");
        Thread t4_3 = new Thread(new MyProgressor(), "P-T3");

        t4_1.start();
        t4_2.start();
        t4_3.start();

        t4_1.join();
        t4_2.join();
        t4_3.join();

        System.out.println("-------------------------");
    }

    private static void task6() throws InterruptedException {
        System.out.println("\n*** Завдання 6: Reader/Printer (wait/notify) ***");

        SharedData sharedData = new SharedData();
        try (Scanner scanner = new Scanner(System.in)) {
            Reader reader = new Reader(sharedData, scanner);
            Printer printer = new Printer(sharedData);

            Thread readerThread = new Thread(reader, "Reader");
            Thread printerThread = new Thread(printer, "Printer");

            readerThread.start();
            printerThread.start();

            readerThread.join();
            printerThread.join();
        }

        System.out.println("-------------------------");
    }

    private static void task7() throws InterruptedException, ExecutionException {
        System.out.println("\n*** Завдання 7: Сума цифр в масиві (ExecutorService) ***");

        final int ARRAY_SIZE = 1_000_000;
        final int NUM_THREADS = 5;

        int[] array = new int[ARRAY_SIZE];
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(10000);
        }

        long startTimeSingle = System.currentTimeMillis();
        long singleThreadSum = calculateSumOfDigits(array, 0, ARRAY_SIZE);
        long endTimeSingle = System.currentTimeMillis();

        System.out.println("\n--- Однопотокове обчислення ---");
        System.out.println("Загальна сума: " + singleThreadSum);
        System.out.println("Час виконання: " + (endTimeSingle - startTimeSingle) + " мс");

        long startTimeMulti = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        int chunkSize = ARRAY_SIZE / NUM_THREADS;
        long multiThreadSum = 0;

        java.util.List<Future<Long>> futures = new java.util.ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * chunkSize;
            int end = (i == NUM_THREADS - 1) ? ARRAY_SIZE : (i + 1) * chunkSize;

            SumFinder sumFinder = new SumFinder(array, start, end);
            futures.add(executor.submit(sumFinder));
        }

        for (Future<Long> future : futures) {
            multiThreadSum += future.get();
        }

        executor.shutdown();
        long endTimeMulti = System.currentTimeMillis();

        System.out.println("\n--- Багатопотокове обчислення (Callable) ---");
        System.out.println("Загальна сума: " + multiThreadSum);
        System.out.println("Час виконання: " + (endTimeMulti - startTimeMulti) + " мс");

        System.out.println("Результати збігаються: " + (singleThreadSum == multiThreadSum));

        System.out.println("-------------------------");
    }

    private static long calculateSumOfDigits(int[] array, int start, int end) {
        long sum = 0;
        for (int i = start; i < end; i++) {
            int number = array[i];
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
        }
        return sum;
    }
}
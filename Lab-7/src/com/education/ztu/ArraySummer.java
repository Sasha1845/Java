package com.education.ztu;

public class ArraySummer implements Runnable {
    private final int[] array;
    private final int start;
    private final int end;
    private final int[] partialSum;
    private final int index;

    public ArraySummer(int[] array, int start, int end, int[] partialSum, int index) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.partialSum = partialSum;
        this.index = index;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            int number = array[i];
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
        }
        partialSum[index] = sum;
    }
}
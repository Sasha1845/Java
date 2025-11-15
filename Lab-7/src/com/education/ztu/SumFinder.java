package com.education.ztu;

import java.util.concurrent.Callable;

public class SumFinder implements Callable<Long> {
    private final int[] array;
    private final int start;
    private final int end;

    public SumFinder(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() {
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
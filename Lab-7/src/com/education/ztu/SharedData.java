package com.education.ztu;

public class SharedData {
    private String data = null; // Змінна для зберігання даних
    private boolean isDataAvailable = false; // Флаг для контролю

    public final Object lock = new Object();

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        this.isDataAvailable = true;
    }

    public void consumeData() {
        this.data = null;
        this.isDataAvailable = false;
    }

    public boolean isDataAvailable() {
        return isDataAvailable;
    }
}
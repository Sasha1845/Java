package com.education.ztu;

enum Location3  {
    KYIV("Київ", 50.4501, 30.5234),
    LVIV("Львів", 49.8397, 24.0297),
    ODESA("Одеса", 46.4825, 30.7233),
    KHARKIV("Харків", 49.9935, 36.2304),
    DNIPRO("Дніпро", 48.4647, 35.0462);

    private final String cityName;
    private final double latitude;
    private final double longitude;

    Location3(String cityName, double latitude, double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return String.format("%s (%.4f, %.4f)", cityName, latitude, longitude);
    }
}

class Operation3 {

    public static double addition(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Потрібно передати хоча б одне число");
        }
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static double subtraction(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Потрібно передати хоча б одне число");
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static double multiplication(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Потрібно передати хоча б одне число");
        }
        double product = 1;
        for (double num : numbers) {
            product *= num;
        }
        return product;
    }

    public static double division(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Потрібно передати хоча б одне число");
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Ділення на нуль неможливе");
            }
            result /= numbers[i];
        }
        return result;
    }

    public static double average(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Потрібно передати хоча б одне число");
        }
        return addition(numbers) / numbers.length;
    }

    public static double maximum(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Потрібно передати хоча б одне число");
        }
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static double minimum(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Потрібно передати хоча б одне число");
        }
        double min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
}

public class Task3 {
    public static void main(String[] args) {
        System.out.println("=== Демонстрація роботи класу Operation ===\n");

        double[] numbers = {10, 5, 3, 7, 2};

        System.out.println("Числа для операцій: 10, 5, 3, 7, 2\n");

        System.out.println("1. Додавання (addition):");
        System.out.println("   Результат: " + Operation3.addition(numbers));

        System.out.println("\n2. Віднімання (subtraction):");
        System.out.println("   Результат: " + Operation3.subtraction(numbers));

        System.out.println("\n3. Множення (multiplication):");
        System.out.println("   Результат: " + Operation3.multiplication(numbers));

        System.out.println("\n4. Ділення (division):");
        System.out.println("   Результат: " + Operation3.division(100, 2, 5));

        System.out.println("\n5. Середнє значення (average):");
        System.out.println("   Результат: " + Operation3.average(numbers));

        System.out.println("\n6. Максимальне значення (maximum):");
        System.out.println("   Результат: " + Operation3.maximum(numbers));

        System.out.println("\n7. Мінімальне значення (minimum):");
        System.out.println("   Результат: " + Operation3.minimum(numbers));

        System.out.println("\n\n=== Всі значення enum Location ===\n");
        for (Location3 location : Location3.values()) {
            System.out.println("   Результат: " + Operation3.minimum(numbers));
            System.out.println("\n\n=== Всі значення enum Location ===\n");
            for (Location location3 : Location.values()) {
                System.out.println(location);
            }
        }
    }
}
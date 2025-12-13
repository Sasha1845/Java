package Classes;

public class Operations {

    public static double addition(double... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static double subtraction(double... numbers) {
        if (numbers.length == 0) return 0;
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static double multiplication(double... numbers) {
        if (numbers.length == 0) return 0;
        double product = 1;
        for (double num : numbers) {
            product *= num;
        }
        return product;
    }

    public static double division(double... numbers) {
        if (numbers.length == 0) return 0;
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            result /= numbers[i];
        }
        return result;
    }

    public static double average(double... numbers) {
        if (numbers.length == 0) return 0;
        return addition(numbers) / numbers.length;
    }

    public static double maximum(double... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("No numbers provided.");
        double max = numbers[0];
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static double minimum(double... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("No numbers provided.");
        double min = numbers[0];
        for (double num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}


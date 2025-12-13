package Classes;

public class OperationsForMock {
    public double addition(double... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    public double subtraction(double... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public double multiplication(double... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        double product = 1;
        for (double num : numbers) {
            product *= num;
        }
        return product;
    }

    public double division(double... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            result /= numbers[i];
        }
        return result;
    }
}

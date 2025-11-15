package com.education.ztu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Завдання 2: Printable ---");
        task2();

        System.out.println("\n--- Завдання 3: Вбудовані ФІ ---");
        task3();

        System.out.println("\n--- Завдання 4 & 5: Stream API та Посилання ---");
        task4_5();

        System.out.println("\n--- Завдання 6: Optional ---");
        task6();
    }

    public static void task2() {
        Printable myPrintLambda = () -> System.out.println("Привіт! Лямбда-вираз для Printable.");
        myPrintLambda.print();
    }

    public static void task3() {
        Predicate<String> isNumeric = s -> {
            try {
                Double.parseDouble(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        System.out.println("a) Predicate:");
        System.out.println("'123' є числом? " + isNumeric.test("123"));

        Predicate<String> isNotEmpty = s -> s != null && !s.trim().isEmpty();
        Predicate<String> isValidNumberString = isNotEmpty.and(isNumeric);
        System.out.println("  '789' є числом І не порожній? " + isValidNumberString.test("789"));

        System.out.println("-----------------");

        Consumer<String> startMessage = s -> System.out.println(s + "Пара почалася о 8:30");
        Consumer<String> endMessage = s -> System.out.println(s + "Пара закінчилася о 9:50");
        Consumer<String> fullLecture = startMessage.andThen(endMessage);

        System.out.println("b) Consumer та andThen():");
        fullLecture.accept("");

        System.out.println("-----------------");

        Supplier<String> uppercaseSentenceSupplier = () -> "Це речення у верхньому регістрі.";
        String result = uppercaseSentenceSupplier.get().toUpperCase();

        System.out.println("c) Supplier:");
        System.out.println("  Речення: " + result);

        System.out.println("-----------------");

        Function<String, Long> productOfNumbers = s -> {
            try {
                return Arrays.stream(s.split("\\s+"))
                        .map(String::trim)
                        .filter(str -> !str.isEmpty())
                        .mapToLong(Long::parseLong)
                        .reduce(1L, (a, b) -> a * b);
            } catch (NumberFormatException e) {
                System.err.println("Помилка: Не всі елементи рядка є числами.");
                return 0L;
            }
        };

        String numbersString = "5 10 2 3";
        long product = productOfNumbers.apply(numbersString);

        System.out.println("d) Function:");
        System.out.println("  Добуток: " + product);
    }

    public static void task4_5() {
        Product[] productsArray = new Product[]{
                new Product("Ноутбук Pro", "Apple", 25000.0, 5),
                new Product("Смартфон X", "Samsung", 15000.0, 10),
                new Product("Клавіатура Механічна", "Logitech", 999.50, 20),
                new Product("Монітор 4K", "Samsung", 12000.0, 3),
                new Product("Веб-камера HD", "Logitech", 450.0, 50),
                new Product("Навушники Бездротові", "Sony", 1500.0, 15)
        };

        Stream<Product> productStream = Arrays.stream(productsArray);

        System.out.println("\n--- 1. Усі бренди (map, Посилання на метод) ---");
        List<String> brands = productStream
                .map(Product::getBrand)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("  Бренди: " + brands);

        productStream = Arrays.stream(productsArray);

        System.out.println("\n--- 2. Два товари ціною < 1000 (filter, limit) ---");
        List<Product> cheapProducts = productStream
                .filter(p -> p.getPrice() < 1000.0)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("  Товари: " + cheapProducts.stream().map(Product::getName).collect(Collectors.joining(", ")));

        productStream = Arrays.stream(productsArray);

        System.out.println("\n--- 3. Сума всіх кількостей товарів (map, reduce) ---");
        Optional<Integer> totalCount = productStream
                .map(Product::getCount)
                .reduce(Integer::sum);

        System.out.println("  Загальна кількість: " + totalCount.orElse(0));

        productStream = Arrays.stream(productsArray);

        System.out.println("\n--- 4. Групування товарів по бренду (groupingBy) ---");
        Map<String, List<Product>> productsByBrand = productStream
                .collect(Collectors.groupingBy(Product::getBrand));

        productsByBrand.forEach((brand, list) -> {
            System.out.println("  Бренд " + brand + ": " + list.size() + " товари(ів)");
        });

        productStream = Arrays.stream(productsArray);

        System.out.println("\n--- 5. Сортування за ціною (sorted, Посилання на метод) ---");
        Product[] sortedProducts = productStream
                .sorted(Comparator.comparing(Product::getPrice))
                .toArray(Product[]::new);

        System.out.println("  Відсортовані товари:");
        for (Product p : sortedProducts) {
            System.out.printf("    - %s: %.2f\n", p.getName(), p.getPrice());
        }

        System.out.println("\n--- 6. Додатково: Об'єднання назв товарів з кількістю > 10 ---");
        String namesWithHighCount = Arrays.stream(productsArray)
                .filter(p -> p.getCount() > 10)
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        System.out.println("  Товари: " + namesWithHighCount);
    }

    public static void task6() {
        int[] numbers1 = {10, 5, 20, 15, 30};
        int[] numbers2 = {};

        String max1 = findMax(numbers1);
        System.out.println("  Масив 1: " + Arrays.toString(numbers1) + " -> Результат: " + max1);

        String max2 = findMax(numbers2);
        System.out.println("  Масив 2: " + Arrays.toString(numbers2) + " -> Результат: " + max2);
    }

    public static String findMax(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .max(Comparator.naturalOrder())
                .map(Object::toString)
                .orElse("Числа відсутні");
    }
}
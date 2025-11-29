package com.education.ztu;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== TASK 2: Регулярні вирази ===\n");
        String text = sampleEmployeesText();
        System.out.println("Оригінальний текст:\n" + text);
        Pattern phonePattern = Pattern.compile(
                "(?:\\+\\d{1,3}[\\s-]?)?(?:\\(\\d{2,5}\\)[\\s-]?|\\d{2,5}[\\s-])?\\d{3,4}[\\s-]?\\d{2,2}[\\s-]?\\d{2,2}");
        Matcher mPhone = phonePattern.matcher(text);
        System.out.println("\nЗнайдені телефони:");
        while (mPhone.find()) System.out.println(" - " + mPhone.group());
        Pattern emailPattern = Pattern.compile(
                "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher mEmail = emailPattern.matcher(text);
        System.out.println("\nЗнайдені email:");
        while (mEmail.find()) System.out.println(" - " + mEmail.group());
        Pattern datePattern = Pattern.compile("(\\b)(\\d{2})\\.(\\d{2})\\.(\\d{4})(\\b)");
        String textWithDatesReformatted = datePattern.matcher(text)
                .replaceAll("$4-$3-$2"); // yyyy-MM-dd
        System.out.println("\nТекст з переформатованими датами:\n" + textWithDatesReformatted);
        String textPositionsUpdated = textWithDatesReformatted
                .replaceAll("\\bJunior Developer\\b", "Middle Developer")
                .replaceAll("\\bIntern\\b", "Junior Developer");
        System.out.println("\nТекст з оновленими посадами:\n" + textPositionsUpdated);
        System.out.println("\n=== TASK 3: Reflection API ===\n");
        Class<Staff> c1 = Staff.class;
        Class<?> c2 = new Staff().getClass();
        Class<?> c3 = Class.forName("com.education.ztu.Staff");
        System.out.println("Class via .class: " + c1.getName());
        System.out.println("Class via instance.getClass(): " + c2.getName());
        System.out.println("Class via Class.forName: " + c3.getName());
        System.out.println("\nDeclared fields:");
        for (Field f : c1.getDeclaredFields()) {
            System.out.printf(" - %s %s\n", f.getType().getSimpleName(), f.getName());
        }
        System.out.println("\nDeclared constructors:");
        for (Constructor<?> ctor : c1.getDeclaredConstructors()) {
            System.out.print(" - " + ctor.getName() + "(");
            Class<?>[] params = ctor.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName() + (i < params.length-1 ? ", " : ""));
            }
            System.out.println(")");
        }
        System.out.println("\nDeclared methods:");
        for (Method mm : c1.getDeclaredMethods()) {
            System.out.print(" - " + mm.getName() + "(");
            Class<?>[] p = mm.getParameterTypes();
            for (int i=0;i<p.length;i++) System.out.print(p[i].getSimpleName() + (i<p.length-1? ", ":""));
            System.out.println(") : " + mm.getReturnType().getSimpleName());
        }
        Constructor<Staff> ctor = c1.getDeclaredConstructor(String.class, int.class);
        Staff staffInstance = ctor.newInstance("Ivan Petrenko", 29);
        System.out.println("\nСтворено об'єкт Staff: " + staffInstance);
        Method greet = c1.getDeclaredMethod("greet", String.class);
        greet.invoke(staffInstance, "Доброго дня");
        Field secretField = c1.getDeclaredField("secretNote");
        secretField.setAccessible(true);
        secretField.set(staffInstance, "Це приватна нотатка через reflection");
        String secretValue = (String) secretField.get(staffInstance);
        System.out.println("Отримано приватне поле secretNote: " + secretValue);
        Method privateMethod = c1.getDeclaredMethod("secretMethod");
        privateMethod.setAccessible(true);
        String secretMethodResult = (String) privateMethod.invoke(staffInstance);
        System.out.println("Результат виклику приватного методу: " + secretMethodResult);
        System.out.println("\n=== TASK 4: Власна анотація ===\n");
        MyAnnotation ann = c1.getAnnotation(MyAnnotation.class);
        if (ann != null) {
            System.out.println("Анотація MyAnnotation присутня на Staff:");
            System.out.println(" - author(): " + ann.author());
            System.out.println(" - version(): " + ann.version());
            System.out.print(" - tags(): ");
            for (String t : ann.tags()) System.out.print(t + " ");
            System.out.println();
        } else {
            System.out.println("Анотація MyAnnotation відсутня.");
        }
        System.out.println("\n=== Кінець роботи програми ===");
    }
    private static String sampleEmployeesText() {
        return String.join("\n",
                "1) Іваненко Петро, 20.05.1995, Junior Developer, 2 years, Kyiv, ivan.pet@company.com, +380 (67) 123-45-67",
                "2) Олена Коваль, 03.03.1988, Senior Manager, 10 years, Lviv, o.koval@mail.ua, 032-222-33-44",
                "3) Сергій Бондар, 15.12.1999, Intern, 0 years, Odesa, s.bondar@example.com, +380671234568",
                "4) Марія Ткач, 01.01.1990, HR Specialist, 5 years, Kharkiv, maria.t@company.org, 057-555-11-22",
                "5) Андрій Шевченко, 30.06.1985, Junior Developer, 3 years, Vinnytsia, andriy.shev@work.ua, +38 050 444 55 66"
        );
    }
}
// =================== TASK 3 & 4 supporting classes ===================
@MyAnnotation(author = "Oleksandr", version = 2, tags = {"dev", "java"})
class Staff {
    public String name;
    private int age;
    private String secretNote = "initial secret";

    public Staff() {
        this.name = "Unknown";
        this.age = 0;
    }
    public Staff(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void greet(String msg) {
        System.out.println("GREET from Staff (" + name + "): " + msg + " — age=" + age);
    }
    private String secretMethod() {
        return "SECRET METHOD: '" + secretNote + "' for " + name;
    }
    @Override
    public String toString() {
        return String.format("Staff{name='%s', age=%d}", name, age);
    }
}
// =================== TASK 4: власна анотація ===================
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String author() default "Unknown";
    int version() default 1;
    String[] tags() default {};
}

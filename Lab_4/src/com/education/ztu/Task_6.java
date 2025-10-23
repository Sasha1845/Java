package com.education.ztu;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    РОБОТА З ДАТАМИ ТА ЧАСОМ                           ║");
        System.out.println("║                    Date and Time Operations                           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("┌───────────────────────────────────────────────────────────────────────┐");
        System.out.println("│            Введіть дату та час початку лабораторної роботи            │");
        System.out.println("└───────────────────────────────────────────────────────────────────────┘");

        System.out.print("  → Рік: ");
        int year = scanner.nextInt();
        System.out.print("  → Місяць (1-12): ");
        int month = scanner.nextInt();
        System.out.print("  → День: ");
        int day = scanner.nextInt();
        System.out.print("  → Година (0-23): ");
        int hour = scanner.nextInt();
        System.out.print("  → Хвилина (0-59): ");
        int minute = scanner.nextInt();
        System.out.print("  → Секунда (0-59): ");
        int second = scanner.nextInt();
        System.out.println();

        LocalDateTime labStartTime = LocalDateTime.of(year, month, day, hour, minute, second);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║              РОЗДІЛ 1: Інформація про введену дату                    ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.printf(" ║  Повна дата і час:        %-42s ║%n", labStartTime.format(dateFormatter));
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.printf(" ║  День тижня:              %-20s (%-20s) ║%n",
                labStartTime.getDayOfWeek(),
                getDayNameInUkrainian(labStartTime.getDayOfWeek()));
        System.out.printf(" ║  День у році:             %-42d ║%n", labStartTime.getDayOfYear());
        System.out.printf(" ║  Місяць:                  %-20s (%-20s) ║%n",
                labStartTime.getMonth(),
                getMonthNameInUkrainian(labStartTime.getMonthValue()));
        System.out.printf(" ║  Рік:                     %-42d ║%n", labStartTime.getYear());
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.printf(" ║  Година:                  %-42d ║%n", labStartTime.getHour());
        System.out.printf(" ║  Хвилина:                 %-42d ║%n", labStartTime.getMinute());
        System.out.printf(" ║  Секунда:                 %-42d ║%n", labStartTime.getSecond());
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║              РОЗДІЛ 2: Перевірка високосного року                     ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        boolean leapYear = Year.isLeap(labStartTime.getYear());
        System.out.printf(" ║  Рік %d %-55s ║%n",
                labStartTime.getYear(),
                (leapYear ? "→ ВИСОКОСНИЙ РІК ✓" : "→ звичайний рік"));
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    РОЗДІЛ 3: Поточний час                             ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.printf(" ║  Поточна дата та час:     %-42s ║%n", nowTime.format(dateFormatter));
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   РОЗДІЛ 4: Порівняння дат                            ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.printf(" ║  Початок лабораторної:    %-42s ║%n", labStartTime.format(dateFormatter));
        System.out.printf(" ║  Поточний час:            %-42s ║%n", nowTime.format(dateFormatter));
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");

        if (nowTime.isAfter(labStartTime)) {
            System.out.println("║  Результат:               Поточний час ПІЗНІШЕ початку            ║");
            Duration timeDifference = Duration.between(labStartTime, nowTime);
            long totalHours = timeDifference.toHours();
            long remainingMinutes = timeDifference.toMinutes() % 60;
            System.out.printf("║  Різниця у часі:          %d год. %d хв.%30s ║%n",
                    totalHours, remainingMinutes, "");
        } else if (nowTime.isBefore(labStartTime)) {
            System.out.println("║  Результат:               Поточний час РАНІШЕ початку             ║");
            Duration timeDifference = Duration.between(nowTime, labStartTime);
            long totalHours = timeDifference.toHours();
            long remainingMinutes = timeDifference.toMinutes() % 60;
            System.out.printf("║  До початку залишилось:   %d год. %d хв.%30s ║%n",
                    totalHours, remainingMinutes, "");
        } else {
            System.out.println("║  Результат:               Час співпадає!                          ║");
        }

        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║            РОЗДІЛ 5: Маніпуляції з датою та часом                     ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.printf(" ║  Початкова дата:          %-42s ║%n", labStartTime.format(dateFormatter));
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");

        LocalDateTime modifiedDateTime = labStartTime;

        modifiedDateTime = modifiedDateTime.plusDays(7);
        System.out.printf("║  +7 днів:                 %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.plusMonths(2);
        System.out.printf("║  +2 місяці:               %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.minusYears(1);
        System.out.printf("║  -1 рік:                  %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.plusHours(3);
        System.out.printf("║  +3 години:               %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.minusMinutes(15);
        System.out.printf("║  -15 хвилин:              %-42s ║%n", modifiedDateTime.format(dateFormatter));

        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                    Встановлення конкретних значень                    ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");

        modifiedDateTime = modifiedDateTime.withYear(2025);
        System.out.printf("║  Рік → 2025:              %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.withMonth(12);
        System.out.printf("║  Місяць → 12:             %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.withDayOfMonth(25);
        System.out.printf("║  День → 25:               %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.withHour(18);
        System.out.printf("║  Година → 18:             %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.withMinute(30);
        System.out.printf("║  Хвилина → 30:            %-42s ║%n", modifiedDateTime.format(dateFormatter));

        modifiedDateTime = modifiedDateTime.withSecond(45);
        System.out.printf("║  Секунда → 45:            %-42s ║%n", modifiedDateTime.format(dateFormatter));

        System.out.println("╠═══════════════════════════════════════════════════════════════════════╣");
        System.out.printf(" ║  ПІДСУМКОВА ДАТА:         %-42s ║%n", modifiedDateTime.format(dateFormatter));
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
        System.out.println();

        scanner.close();
    }

    public static String getDayNameInUkrainian(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY: return "Понеділок";
            case TUESDAY: return "Вівторок";
            case WEDNESDAY: return "Середа";
            case THURSDAY: return "Четвер";
            case FRIDAY: return "П'ятниця";
            case SATURDAY: return "Субота";
            case SUNDAY: return "Неділя";
            default: return "";
        }
    }

    public static String getMonthNameInUkrainian(int monthNumber) {
        switch (monthNumber) {
            case 1: return "Січень";
            case 2: return "Лютий";
            case 3: return "Березень";
            case 4: return "Квітень";
            case 5: return "Травень";
            case 6: return "Червень";
            case 7: return "Липень";
            case 8: return "Серпень";
            case 9: return "Вересень";
            case 10: return "Жовтень";
            case 11: return "Листопад";
            case 12: return "Грудень";
            default: return "";
        }
    }
}
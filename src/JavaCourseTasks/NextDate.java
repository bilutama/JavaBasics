package JavaCourseTasks;

import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date as D/M/YYYY");

        System.out.print("Day: ");
        int day = scanner.nextInt();

        System.out.print("Month: ");
        int month = scanner.nextInt();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        if (year < 0 || month > 12 || month < 0 || day < 0) {
            System.out.println("Date is not valid.");
        } else {
            // monthIndex is used to consider leap-year February while getting daysInMonth
            int monthIndex = month;

            if (isLeap(year) && month == 2) {
                monthIndex = 0;
            }

            // TODO: replace the array
            // Index [0] reserved for leap-year February, other indexes are 1 - Jan, 2 - Feb etc.
            final int[] daysInMonth = new int[]{29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (day < daysInMonth[monthIndex]) {
                // Date is valid and the day is NOT last in the month
                System.out.printf("The next day is %02d.%02d.%d", (day + 1), month, year);
            } else if (day == daysInMonth[monthIndex]) {
                // Date is valid and the day IS the last in the month
                if (month == 12) {
                    // It is December, 31
                    System.out.printf("The next day is %02d.%02d.%d", 1, 1, (year + 1));
                } else {
                    // It is NOT December, the last day in the month
                    System.out.printf("The next day is %02d.%02d.%d", 1, (month + 1), year);
                }
            } else {
                System.out.println("Date is not valid.");
            }
        }
    }

    private static boolean isLeap(int year) {
        return (year % 100 != 0) && (year % 4 == 0) || (year % 100 == 0) && (year % 400 == 0);
    }
}

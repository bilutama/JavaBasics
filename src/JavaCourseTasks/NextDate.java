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
            System.out.println("Data is not valid");
        } else {
            int monthIndex = month;

            if (isLeap(year) && month == 2) {
                monthIndex = 0;
            }

            final int[] daysInMonths = new int[]{29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (day < daysInMonths[monthIndex]) {
                // Date is valid and the day is NOT last in the month
                System.out.printf("The next date is %02d %02d %d", (day + 1), month, year);
            } else if (day == daysInMonths[monthIndex]) {
                // Date is valid and the day IS the last in the month
                if (month == 12) {
                    // It is December, 31
                    System.out.printf("The next date is %02d %02d %d", 1, 1, (year + 1));
                } else {
                    // It is NOT December, the last day in the month
                    System.out.printf("The next date is %02d %02d %d", 1, (month + 1), year);
                }
            } else {
                System.out.println("Data is not valid");
            }
        }
    }

    private static boolean isLeap(int year) {
        if ((year % 4 == 0) && (year % 100 != 0)) {
            return true; // A leap year
        } else {
            return (year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0);
        }
    }
}
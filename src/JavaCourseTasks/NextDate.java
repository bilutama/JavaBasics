package JavaCourseTasks;

import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date as D/M/YYYY");
        int day = scanner.nextInt();

        System.out.println("Enter date as D/M/YYYY");
        int month = scanner.nextInt();

        System.out.println("Enter date as D/M/YYYY");
        int year = scanner.nextInt();

        // Count days in months, index 0 corresponds to February in a leap year (29 days)
        final int[] daysInMonths = new int[] {29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    private static int getDaysInYear (int year) {
        if ((year % 4 == 0) && (year % 100 != 0)) {
            return 366; // A leap year
        } else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
            return 366; // A leap year
        } else {
            return 365; // NOT a leap year
        }
    }

    private static boolean isDateValid (int day, int month, int year) {
        if  (year < 0 || month > 12 || month < 0 || day < 0) {
            return false;
        } else {
            int monthIndex = month;

            if (getDaysInYear(year) == 366 && month == 2) {
                monthIndex = 0;
            }

            final int[] daysInMonths = new int[] {29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            return day <= daysInMonths[monthIndex];
        }
    }
}
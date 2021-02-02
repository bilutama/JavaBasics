package JavaCourseTasks;

import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date as D/M/YYYY (0 to terminate)");

        System.out.print("Day: ");
        int day = scanner.nextInt();
        
        if (day == 0) {
            return;
        }

        System.out.print("Month: ");
        int month = scanner.nextInt();

        if (month == 0) {
            return;
        }
        
        System.out.print("Year: ");
        int year = scanner.nextInt();
        
        if (year == 0) {
            return;
        }

        if (year < 0 || month > 12 || month < 0 || day < 0) {
            System.out.println("Date is not valid.");
        } else {
            int daysCountInMonth;
            
            if (month == 2) {
                if (isLeap(year)) {
                    daysCountInMonth = 29;
                } else {
                    daysCountInMonth = 28;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                daysCountInMonth = 30;
            } else {
                daysCountInMonth = 31;
            }
                    
            if (day < daysCountInMonth) {
                // Date is valid and the day is NOT last in the month
                System.out.printf("The next day is %02d.%02d.%d", (day + 1), month, year);
            } else if (day == daysCountInMonth) {
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
        return ((year % 100 != 0) && (year % 4 == 0)) || (year % 400 == 0);
    }
}
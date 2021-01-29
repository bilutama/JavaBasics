package Lect_03;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println("*** Determines whether it is a leap year ***");

        Scanner scanner = new Scanner(System.in);

        int year = -1;

        // Read a year
        while (year <= 0) {
            System.out.print("Enter a year (value > 0): ");
            year = scanner.nextInt();
        }

        boolean isLeap = true;

        // Check whether the year in not a leap
        if (year % 4 != 0) {
            isLeap = false;
        } else if ((year % 100 != 0) && (year % 400 == 0)) {
            isLeap = false;
        }

        // Output
        if (isLeap) {
            System.out.printf("%d is a leap year.%n", year);
        } else {
            System.out.printf("%d is not a leap year.%n", year);
        }
    }
}
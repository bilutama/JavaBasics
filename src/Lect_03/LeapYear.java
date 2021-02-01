package Lect_03;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println("*** Determines whether it is a leap year ***");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int year = -1;

            while (year < 0) {
                System.out.print("Enter a year (value > 0 or 0 to terminate): ");
                year = scanner.nextInt();

                if (year == 0) {
                    System.exit(0);
                }
            }

            if ((year % 100 != 0) && (year % 4 == 0) || (year % 100 == 0) && (year % 400 == 0)) {
                System.out.printf("%d is a leap year.%n", year);
            } else {
                System.out.printf("%d is NOT a leap year.%n", year);
            }
        }
    }
}

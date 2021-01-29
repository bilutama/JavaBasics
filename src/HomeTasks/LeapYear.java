package HomeTasks;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println("*** Determines whether it is a leap year ***");

        Scanner scanner = new Scanner(System.in);

        int year = -1;

        while (year <= 0) {
            System.out.print("Enter a year (value > 0): ");
            year = scanner.nextInt();
        }

        boolean isLeap = true;

        if (year % 4 != 0) {
            isLeap = false;
        } else if ((year % 100 != 0) && (year % 400 == 0)) {
            isLeap = false;
        }

        if (isLeap) {
            System.out.printf("%d is a leap year.%n", year);
        } else {
            System.out.printf("%d is not a leap year.%n", year);
        }
    }
}
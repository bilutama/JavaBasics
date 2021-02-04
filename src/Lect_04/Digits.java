package Lect_04;

import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        System.out.println("*** Operations with number digits ***");

        Scanner scanner = new Scanner(System.in);

        int userNumber = 0;
        
        while (userNumber < 1) {
            System.out.print("Enter a number (> 0): ");
            userNumber = scanner.nextInt();
        }

        int temporaryNumber = userNumber;
        int digitsSum = 0;
        int oddDigitsSum = 0;
        int maximumDigit = 0;

        while (temporaryNumber > 0) {
            int lastDigit = temporaryNumber % 10;
            digitsSum += lastDigit;

            if (lastDigit > maximumDigit) {
                maximumDigit = lastDigit;
            }

            if (lastDigit % 2 == 1) {
                oddDigitsSum += lastDigit;
            }

            temporaryNumber /= 10;
        }

        System.out.printf("Sum of digits = %d%n", digitsSum);
        System.out.printf("Sum of odd digits = %d%n", oddDigitsSum);
        System.out.printf("Maximum digit = %d%n", maximumDigit);
    }
}
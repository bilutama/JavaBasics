package Lect_04;

import java.util.Scanner;

public class NumbersInRow {
    public static void main(String[] args) {
        System.out.println("*** Prints numbers in rows ***");

        Scanner scanner = new Scanner(System.in);

        int firstNumber = 0;
        while (firstNumber < 1) {
            System.out.print("The first number to print (> 0): ");
            firstNumber = scanner.nextInt();
        }

        int lastNumber = 0;
        while (lastNumber < 1) {
            System.out.print("The last number to print (> 0): ");
            lastNumber = scanner.nextInt();
        }

        if (lastNumber < firstNumber) {
            int temporaryNumber = lastNumber;
            lastNumber = firstNumber;
            firstNumber = temporaryNumber;
        }

        int numbersCountInRow = 0;
        while (numbersCountInRow < 1) {
            System.out.print("How many numbers in a row (> 0): ");
            numbersCountInRow = scanner.nextInt();
        }

        for (int i = firstNumber; i <= lastNumber; i++) {
            System.out.printf("%4d", i);

            if ((i - firstNumber + 1) % numbersCountInRow == 0) {
                System.out.println();
            }
        }
    }
}

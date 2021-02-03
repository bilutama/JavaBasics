package Lect_04;

import java.util.Scanner;

public class AveragesWhile {
    public static void main(String[] args) {
        System.out.println("*** Calculates arithmetic average ***");

        Scanner scanner = new Scanner(System.in);

        int firstNumber = 0;
        while (firstNumber < 1) {
            System.out.print("The first number (> 0): ");
            firstNumber = scanner.nextInt();
        }

        int lastNumber = 0;
        while (lastNumber < 1) {
            System.out.print("The last number (> 0): ");
            lastNumber = scanner.nextInt();
        }

        if (lastNumber < firstNumber) {
            int temporaryNumber = lastNumber;
            lastNumber = firstNumber;
            firstNumber = temporaryNumber;
        }

        int numbersSum = 0;
        int currentNumber = firstNumber;

        while (currentNumber <= lastNumber) {
            numbersSum += currentNumber;
            ++currentNumber;
        }

        double arithmeticAverage = (double) numbersSum / (lastNumber - firstNumber + 1);
        System.out.printf("Arithmetic average is %.3f%n", arithmeticAverage);

        int evenNumbersCount = 0;
        int evenNumbersSum = 0;
        currentNumber = firstNumber;

        while (currentNumber <= lastNumber) {
            if (currentNumber % 2 == 0) {
                evenNumbersSum += currentNumber;
                ++evenNumbersCount;
            }

            ++currentNumber;
        }

        if (evenNumbersCount > 0) {
            double arithmeticAverageEvenOnly = (double) evenNumbersSum / evenNumbersCount;
            System.out.printf("Arithmetic average for even numbers only is %.3f", arithmeticAverageEvenOnly);
        } else {
            System.out.println("No even numbers to calculate their average.");
        }
    }
}
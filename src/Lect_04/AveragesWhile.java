package Lect_04;

import java.util.Scanner;

public class AveragesWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*** Calculates arithmetic average ***");

        System.out.print("The first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("The last number: ");
        int lastNumber = scanner.nextInt();

        if (lastNumber < firstNumber) {
            int temporaryNumber = lastNumber;
            lastNumber = firstNumber;
            firstNumber = temporaryNumber;
        }

        int numbersSum = 0;
        int currentNumber = firstNumber;
        int evenNumbersCount = 0;
        int evenNumbersSum = 0;
        
        while (currentNumber <= lastNumber) {
            numbersSum += currentNumber;
            
            if (currentNumber % 2 == 0) {
                evenNumbersSum += currentNumber;
                ++evenNumbersCount;
            }
            
            ++currentNumber;
        }

        double arithmeticAverage = (double) numbersSum / (lastNumber - firstNumber + 1);
        System.out.printf("Arithmetic average is %.3f%n", arithmeticAverage);

        if (evenNumbersCount > 0) {
            double arithmeticAverageEvenNumbers = (double) evenNumbersSum / evenNumbersCount;
            System.out.printf("Arithmetic average for even numbers only is %.3f", arithmeticAverageEvenNumbers);
        } else {
            System.out.println("No even numbers to calculate their average.");
        }
    }
}

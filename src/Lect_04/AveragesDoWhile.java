package Lect_04;

import java.util.Scanner;

public class AveragesDoWhile {
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
        int evenNumbersCount = 0;
        int evenNumbersSum = 0;
        int i = firstNumber;

        do {
            numbersSum += i;
            
            if (i % 2 == 0) {
                evenNumbersSum += i;
                ++evenNumbersCount;
            }
            
            ++i;
        } while (i <= lastNumber);

        double average = (double) numbersSum / (lastNumber - firstNumber + 1);
        System.out.printf("Average is %.3f%n", average);

        if (evenNumbersCount > 0) {
            double evenNumbersAverage = (double) evenNumbersSum / evenNumbersCount;
            System.out.printf("Average for even numbers is %.3f", evenNumbersAverage);
        } else {
            System.out.println("No even numbers to calculate their average.");
        }
    }
}

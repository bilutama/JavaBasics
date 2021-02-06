package ClassTasks;

import java.util.Scanner;

public class FindingSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        for (int i = firstNumber; i <= lastNumber; ++i) {
            numbersSum += i;

            if (i % 2 == 0) {
                ++evenNumbersCount;
                evenNumbersSum += i;
            }
        }

        System.out.printf("Sum of all the numbers: %d%n", numbersSum);
        System.out.printf("Sum of even numbers: %d%n", evenNumbersSum);
        System.out.printf("Count of even numbers: %d%n", evenNumbersCount);
    }
}

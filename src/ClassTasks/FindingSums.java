package ClassTasks;

import java.util.Scanner;

public class FindingSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("The first number to sum: ");
        int smallNumber = scanner.nextInt();

        System.out.print("The last number to sum: ");
        int bigNumber = scanner.nextInt();

        if (bigNumber < smallNumber) {
            int temporaryNumber = bigNumber;
            bigNumber = smallNumber;
            smallNumber = temporaryNumber;
        }

        int numbersSum = 0;
        int evenNumbersCount = 0;
        int evenNumbersSum = 0;

        for (int i = smallNumber; i <= bigNumber; ++i) {
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
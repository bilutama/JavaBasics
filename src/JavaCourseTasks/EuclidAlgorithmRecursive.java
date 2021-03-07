package JavaCourseTasks;

import java.util.Scanner;

public class EuclidAlgorithmRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Euclid Algorithm (GCD for two numbers) ***");

        System.out.print("The first number: ");
        int number1 = Math.abs(scanner.nextInt());

        System.out.print("The second number: ");
        int number2 = Math.abs(scanner.nextInt());

        try {
            System.out.printf("The greatest common divisor = %d", getGreatestCommonDivisor(number1, number2));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int getGreatestCommonDivisor(int number1, int number2) {
        if (number2 == 0 && number1 == 0) {
            throw new RuntimeException("Both numbers are zeros");
        } else if (Math.min(number1, number2) == 0) {
            return Math.max(number1, number2);
        }

        if (number1 % number2 == 0) {
            return number2;
        }

        return getGreatestCommonDivisor(number2, number1 % number2);
    }
}
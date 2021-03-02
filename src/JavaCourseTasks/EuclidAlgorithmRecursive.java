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
            throw new RuntimeException();
        }

        int dividend = Math.max(number1, number2);
        int divisor = Math.min(number1, number2);

        if (divisor == 0) {
            return dividend;
        }

        return getGreatestCommonDivisor(divisor, dividend % divisor);
    }
}
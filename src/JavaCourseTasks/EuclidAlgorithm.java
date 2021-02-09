package JavaCourseTasks;

import java.util.Scanner;

public class EuclidAlgorithm {
    public static void main(String[] args) {
        System.out.println("*** Euclid Algorithm (GCD for two numbers) ***");

        Scanner scanner = new Scanner(System.in);

        System.out.print("The first number: ");
        int number1 = Math.abs(scanner.nextInt());

        System.out.print("The second number: ");
        int number2 = Math.abs(scanner.nextInt());

        if (number1 == 0 && number2 == 0) {
            System.out.println("ERROR: There is no greatest common divisor for zeros");
        } else if (Math.min(number1, number2) == 0) {
            System.out.printf("The greatest common divisor = %d%n", Math.max(number1, number2));
        } else {
            int dividend = Math.max(number1, number2);
            int divisor = Math.min(number1, number2);
            int remainder = dividend % divisor;

            while (remainder > 0) {
                dividend = divisor;
                divisor = remainder;
                remainder = dividend % divisor;
            }

            System.out.printf("The greatest common divisor = %d%n", divisor);
        }
    }
}
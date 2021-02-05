package JavaCourseTasks;

import java.util.Scanner;

public class EuclidAlgorithm {
    public static void main(String[] args) {
        System.out.println("*** Euclid Algorithm (GCD for two numbers) ***");

        Scanner scanner = new Scanner(System.in);

        int firstNumber = 0;

        while (firstNumber < 1) {
            System.out.print("The first number (> 0): ");
            firstNumber = scanner.nextInt();
        }

        int secondNumber = 0;

        while (secondNumber < 1) {
            System.out.print("The last number (> 0): ");
            secondNumber = scanner.nextInt();
        }

        if (secondNumber < firstNumber) {
            int temporaryNumber = secondNumber;
            secondNumber = firstNumber;
            firstNumber = temporaryNumber;
        }

        int modulo = firstNumber % secondNumber;

        while (modulo > 0) {
            modulo = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = modulo;
        }

        System.out.printf("GCD = %d", firstNumber);
    }
}

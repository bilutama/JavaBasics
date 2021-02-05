package JavaCourseTasks;

import java.util.Scanner;

public class EuclidAlgorithm {
    public static void main(String[] args) {
        System.out.println("*** Euclid Algorithm (GCD for two numbers) ***");

        Scanner scanner = new Scanner(System.in);

        int firstNumber = 0;

        System.out.print("The first number: ");
        firstNumber = Math.abs(scanner.nextInt());

        int secondNumber = 0;

        System.out.print("The last number: ");
        secondNumber = Math.abs(scanner.nextInt());

        if (secondNumber < firstNumber) {
            int temporaryNumber = secondNumber;
            secondNumber = firstNumber;
            firstNumber = temporaryNumber;
        }

        int modulo = 1;

        while (modulo != 0) {
            modulo = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = modulo;
        }

        System.out.printf("GCD = %d", firstNumber);
    }
}
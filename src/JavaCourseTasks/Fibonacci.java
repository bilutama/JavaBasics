package JavaCourseTasks;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("*** Finds Fibonacci numbers ***");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the index of a Fibonacci number (> 0 or 0 to terminate): ");
            int fibonacciIndex = scanner.nextInt();

            if (fibonacciIndex < 0) {
                System.out.println("Invalid index.");
            } else if (fibonacciIndex == 0) {
                System.exit(0);
            } else {
                int fibonacciNumber = getFibonacciNumberByIndex(fibonacciIndex);
                System.out.printf("F = %d.%n", fibonacciNumber);
            }
        }
    }

    static int getFibonacciNumberByIndex(int index) {
        if (index == 1) {
            return 0;
        } else if (index == 2) {
            return 1;
        } else {
            return getFibonacciNumberByIndex(index - 1) + getFibonacciNumberByIndex(index - 2);
        }
    }
}
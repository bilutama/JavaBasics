package JavaCourseTasks;

import java.util.Scanner;

public class FibonacciDirectSum {
    public static void main(String[] args) {
        System.out.println("*** Finds Fibonacci numbers ***");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an index (> 0 and < 47): ");
        int fibonacciIndex = scanner.nextInt();

        long algorithmStartTime = System.currentTimeMillis();

        if (fibonacciIndex < 0 || fibonacciIndex > 46) {
            System.out.println("Invalid index.");
        } else {
            int[] fibonacciNumbers = new int[3];
            fibonacciNumbers[1] = 1;
            fibonacciNumbers[2] = 1;

            if (fibonacciIndex > 2) {
                int i = 2;
                int temporaryNumber;

                while (i < fibonacciIndex) {
                    temporaryNumber = fibonacciNumbers[1] + fibonacciNumbers[2];
                    fibonacciNumbers[1] = fibonacciNumbers[2];
                    fibonacciNumbers[2] = temporaryNumber;
                    ++i;
                }

                System.out.printf("F = %d.%n", fibonacciNumbers[2]);
            } else {
                System.out.printf("F = %d.%n", fibonacciNumbers[fibonacciIndex]);
            }


            long algorithmEndTime = System.currentTimeMillis();
            System.out.printf("< Executed in %dms >%n", algorithmEndTime - algorithmStartTime);
        }
    }
}
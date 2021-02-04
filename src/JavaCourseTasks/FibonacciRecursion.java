package JavaCourseTasks;

import java.util.Scanner;

public class FibonacciRecursion {
    public static void main(String[] args) {
        System.out.println("*** Finds Fibonacci numbers ***");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an index (> 0 and < 47; or 0 to terminate): ");
            int fibonacciIndex = scanner.nextInt();

            long algorithmStartTime = System.currentTimeMillis();

            if (fibonacciIndex < 0 || fibonacciIndex > 46) {
                System.out.println("Invalid index.");
            } else if (fibonacciIndex == 0) {
                System.exit(0);
            } else {
                int fibonacciNumber = getFibonacciNumberByIndex(fibonacciIndex);
                System.out.printf("F = %d.%n", fibonacciNumber);

                long algorithmEndTime = System.currentTimeMillis();
                System.out.printf("< Executed in %dms >%n", algorithmEndTime - algorithmStartTime);
            }
        }
    }

    static int getFibonacciNumberByIndex(int index) {
        if (index == 1 || index == 2) {
            return index - 1;
        } else {
            return getFibonacciNumberByIndex(index - 1) + getFibonacciNumberByIndex(index - 2);
        }
    }
}
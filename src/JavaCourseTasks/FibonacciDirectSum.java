package JavaCourseTasks;

import java.util.Scanner;

public class FibonacciDirectSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Finds Fibonacci numbers ***");
        
        System.out.print("Enter an index (< 93): ");
        int fibonacciIndex = scanner.nextInt();

        if (fibonacciIndex == 0 || fibonacciIndex == 1) {
            System.out.printf("Number #%d = %,d%n", fibonacciIndex, fibonacciIndex);
        } else if (fibonacciIndex > 92) {
            System.out.println("Invalid index.");
        } else {
            long fibonacciNumber1 = 0;
            long fibonacciNumber2 = 1;
            long fibonacciNumber3 = fibonacciNumber2 + fibonacciNumber1;

            int i = 2;
            while (i != fibonacciIndex) {
                fibonacciNumber1 = fibonacciNumber2;
                fibonacciNumber2 = fibonacciNumber3;
                fibonacciNumber3 = fibonacciNumber2 + fibonacciNumber1;
                ++i;
            }

            System.out.printf("Number #%d = %,d%n", fibonacciIndex, fibonacciNumber3);
        }
    }
}
package JavaCourseTasks;

import java.util.Scanner;

public class FibonacciDirectSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Finds Fibonacci numbers ***");
        
        System.out.print("Enter an index (< 93): ");
        int fibonacciIndex = scanner.nextInt();

        if (fibonacciIndex == 0 || fibonacciIndex == 1) {
            System.out.printf("Number #%d = %d%n", fibonacciIndex, fibonacciIndex);
        } else if (fibonacciIndex > 92) {
            System.out.println("Invalid index.");
        } else {
            long fibonacciNumber1 = 0;
            long fibonacciNumber2 = 1;
            long fibonacciNumber3 = 1;

            int i = 2;
            while (i != fibonacciIndex) {
                fibonacciNumber1 = fibonacciNumber2;
                fibonacciNumber2 = fibonacciNumber3;
                fibonacciNumber3 = fibonacciNumber2 + fibonacciNumber1;
                ++i;
            }

            System.out.printf("Number #%d = %,d%n", fibonacciIndex, fibonacciNumber3);
        }

/*
        if (fibonacciIndex > 0 && fibonacciIndex < 93) {
            long[] fibonacciNumbers = new long[2];
            fibonacciNumbers[1] = 1L;
            
            int i = 1;

            while (i < fibonacciIndex) {
                long temporaryNumber = fibonacciNumbers[0] + fibonacciNumbers[1];
                fibonacciNumbers[0] = fibonacciNumbers[1];
                fibonacciNumbers[1] = temporaryNumber;
                ++i;
            }

            System.out.printf("Number #%d = %d%n", fibonacciIndex, fibonacciNumbers[1]);            
        } else if (fibonacciIndex == 0) {
            System.out.printf("Number #%d = %d%n", fibonacciIndex, 0);
        } else {
            System.out.println("Invalid index.");
        }

        long algorithmEndTime = System.currentTimeMillis();
        System.out.printf("< Executed in %dms >%n", algorithmEndTime - algorithmStartTime);

 */
    }
}
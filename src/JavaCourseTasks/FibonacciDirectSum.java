package JavaCourseTasks;

import java.util.Scanner;

public class FibonacciDirectSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Finds Fibonacci numbers ***");
        
        System.out.print("Enter an index (> 0 and < 93): ");
        int fibonacciIndex = scanner.nextInt();

        long algorithmStartTime = System.currentTimeMillis();

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
    }
}

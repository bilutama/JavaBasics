package Lect_05;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Returns prime numbers ***");

        int userNumber = 0;

        while (userNumber < 2) {
            System.out.print("Enter the number (> 1): ");
            userNumber = scanner.nextInt();
        }

        long algorithmStartTime = System.currentTimeMillis();

        boolean[] isPrime = new boolean[userNumber];
        isPrime[0] = false;

        for (int i = 1; i < userNumber; ++i) {
            isPrime[i] = true;
        }

        for (int n = 2; n * n <= userNumber; ++n) {
            if (isPrime[n - 1]) {
                for (int j = n * n; j <= userNumber; j += n) {
                    isPrime[j - 1] = false;
                }
            }
        }

        long algorithmEndTime = System.currentTimeMillis();

        final int numbersInRow = 10;
        int primeNumbersCount = 0;

        for (int n = 2; n <= userNumber; ++n) {
            if (isPrime[n - 1]) {
                ++primeNumbersCount;
                System.out.printf("%4d ", n);

                if (primeNumbersCount % numbersInRow == 0) {
                    System.out.println();
                }
            }
        }

        System.out.printf("%n%n");
        System.out.printf("< %d prime numbers found >%n", primeNumbersCount);
        System.out.printf("< Executed in %dms >%n", algorithmEndTime - algorithmStartTime);
    }
}
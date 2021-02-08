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

        boolean[] isPrime = new boolean[userNumber];

        for (int i = 1; i < userNumber; ++i) {
            isPrime[i] = true;
        }

        for (int n = 2; n <= userNumber; ++n) {
            if (isPrime[n - 1]) {
                System.out.printf("%4d%n", n);
                for (int j = n * n; j <= userNumber; j += n) {
                    isPrime[j - 1] = false;
                }
            }
        }
    }
}

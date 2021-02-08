package Lect_05;

import java.util.Scanner;

public class PrimeNumbersSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Returns prime numbers ***");

        int userNumber = 0;

        while (userNumber < 2) {
            System.out.print("Enter the number (> 1): ");
            userNumber = scanner.nextInt();
        }

        for (int n = 2; n <= userNumber; ++n) {
            boolean isPrime = true;

            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.printf("%4d%n", n);
            }
        }
    }
}
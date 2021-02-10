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

        for (int i = 2; i <= userNumber; ++i) {
            boolean isPrime = true;

            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.printf("%4d%n", i);
            }
        }
    }
}
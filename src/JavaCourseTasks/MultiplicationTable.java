package JavaCourseTasks;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("*** Prints numbers in rows ***");

        Scanner scanner = new Scanner(System.in);

        int firstNumber = 0;

        while (firstNumber < 2) {
            System.out.print("The first number (> 1): ");
            firstNumber = scanner.nextInt();
        }

        int lastNumber = 0;

        while (lastNumber < 2) {
            System.out.print("The last number (> 1): ");
            lastNumber = scanner.nextInt();
        }

        for (int i = 1; i <= firstNumber; i++) {
            if (i > 1) {
                System.out.printf("%4d", i);
            } else {
                System.out.print("    ");
            }
        }

        System.out.println();

        for (int i = 1; i <= firstNumber; i++) {
            System.out.print("____");
        }

        System.out.println();

        for (int i = 2; i <= firstNumber; i++) {
            for (int j = 1; j <= lastNumber; j++) {
                if (j == 1) {
                    System.out.printf("%3d|", i);
                } else {
                    System.out.printf("%4d", i * j);
                }
            }
            System.out.println();
        }
    }
}
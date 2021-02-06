package JavaCourseTasks;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("*** Prints multiplication table ***");

        Scanner scanner = new Scanner(System.in);

        int firstNumber = 0;

        while (firstNumber < 2) {
            System.out.print("Maximum row number (> 1): ");
            firstNumber = scanner.nextInt();
        }

        int secondNumber = 0;

        while (secondNumber < 2) {
            System.out.print("Maximum column number (> 1): ");
            secondNumber = scanner.nextInt();
        }

        // printing the first line
        for (int i = 1; i <= secondNumber; i++) {
            if (i > 1) {
                System.out.printf("%4d", i);
            } else {
                System.out.print("    ");
            }
        }

        System.out.println();

        // printing the separator
        for (int i = 1; i <= secondNumber; i++) {
            System.out.print("____");
        }

        System.out.println();

        // printing the multiplication table
        for (int i = 2; i <= firstNumber; i++) {
            for (int j = 1; j <= secondNumber; j++) {
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
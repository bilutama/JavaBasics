package Lect_03;

import java.util.Scanner;

public class MinMaxIfElse {
    public static void main(String[] args) {
        System.out.println("*** Returns minimum of two numbers provided ***");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        if (number1 == number2) {
            System.out.println("Numbers are equal.");
        } else if (number1 > number2) {
            System.out.printf("%d is the biggest, %d is the smallest.", number1, number2);
        } else {
            System.out.printf("%d is the biggest, %d is the smallest.", number2, number1);
        }
    }
}
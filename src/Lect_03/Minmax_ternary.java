package Lect_03;

import java.util.Scanner;

public class Minmax_ternary {
    public static void main(String[] args) {
        System.out.println("*** Returns minimum of two numbers provided ***");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        if ((number1 != number2)) {
            int maximumNumber = (number1 > number2) ? number1 : number2;
            int minimumNumber = (number1 < number2) ? number1 : number2;
            System.out.printf("%d is the biggest, %d is the smallest.", maximumNumber, minimumNumber);
        } else {
            System.out.println("Numbers are equal.");
        }
    }
}


package Lect_10;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Returns power of a number ***");

        System.out.println("Enter a number: ");
        double number = scanner.nextDouble();

        int power = -1;

        while (power < 0) {
            System.out.println("Enter a power (>= 0): ");
            power = scanner.nextInt();
        }

        System.out.printf("%.3f ^ %d = %.3f (calculated recursively)%n", number, power, getNumberRaisedToPowerRecursively(number, power));
        System.out.printf("%.3f ^ %d = %.3f (calculated cyclically)%n", number, power, getNumberRaisedToPower(number, power));
    }

    public static double getNumberRaisedToPowerRecursively(double number, int power) {
        if (power == 0) {
            return 1;
        }

        return number * getNumberRaisedToPowerRecursively(number, power - 1);
    }

    public static double getNumberRaisedToPower(double number, int power) {
        double numberInPower = 1.0;

        for (int i = 0; i < power; ++i) {
            numberInPower *= number;
        }

        return numberInPower;
    }
}
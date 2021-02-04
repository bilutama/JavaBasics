package Lect_04;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        System.out.println("*** Executes an operation with two numbers ***");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the first operand: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Please enter the second operand: ");
        double operand2 = scanner.nextDouble();

        System.out.println("Operations available:");
        System.out.println("code 1 for +");
        System.out.println("code 2 for -");
        System.out.println("code 3 for *");
        System.out.println("code 4 for /");

        System.out.print("Enter the code: ");
        int operatorCode = scanner.nextInt();

        switch (operatorCode) {
            case 1:
                System.out.printf("%.3f + %.3f = %.3f", operand1, operand2, operand1 + operand2);
                break;
            case 2:
                System.out.printf("%.3f - %.3f = %.3f", operand1, operand2, operand1 - operand2);
                break;
            case 3:
                System.out.printf("%.3f * %.3f = %.3f", operand1, operand2, operand1 * operand2);
                break;
            case 4:
                double epsilon = 1.0E-10;
                
                if (Math.abs(operand2) < epsilon) {
                    System.out.println("Error (Dividing by 0)");
                } else {
                    System.out.printf("%.3f / %.3f = %.3f", operand1, operand2, operand1 / operand2);
                }
                
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}

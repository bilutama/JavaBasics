package Lect_04;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        System.out.println("*** Executes an operation with two numbers ***");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the first operand: ");
        double firstOperand = scanner.nextDouble();

        System.out.print("Please enter the second operand: ");
        double secondOperand = scanner.nextDouble();

        System.out.println("Operations available:");
        System.out.println("code 1 for +");
        System.out.println("code 2 for -");
        System.out.println("code 3 for *");
        System.out.println("code 4 for /");

        System.out.print("Enter the code: ");
        int operatorCode = scanner.nextInt();

        switch (operatorCode) {
            case 1:
                System.out.printf("%.3f + %.3f = %.3f", firstOperand, secondOperand, firstOperand + secondOperand);
                break;
            case 2:
                System.out.printf("%.3f - %.3f = %.3f", firstOperand, secondOperand, firstOperand - secondOperand);
                break;
            case 3:
                System.out.printf("%.3f * %.3f = %.3f", firstOperand, secondOperand, firstOperand * secondOperand);
                break;
            case 4:
                double epsilon = 1.0E-10;
                
                if (Math.abs(secondOperand) < epsilon) {
                    System.out.println("Error (Dividing by 0)");
                } else {
                    System.out.printf("%.3f / %.3f = %.3f", firstOperand, secondOperand, firstOperand / secondOperand);
                }
                
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}

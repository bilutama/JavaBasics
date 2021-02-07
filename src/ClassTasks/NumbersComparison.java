package ClassTasks;

import java.util.Scanner;

public class NumbersComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("The first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("The second number: ");
        double secondNumber = scanner.nextDouble();

        double epsilon = 1.0e-10;
        if (Math.abs(secondNumber - firstNumber) > epsilon){
            System.out.print("Number are NOT equal.");
        } else {
            System.out.print("Number are equal.");
        }
    }
}
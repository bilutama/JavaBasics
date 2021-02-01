package JavaCourseTasks;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        System.out.println("*** Solves quadratic equations ***");

        Scanner scanner = new Scanner(System.in);

        System.out.println("a * x^2 + b * x + c = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("There is no equation. Identity 0 == 0 is correct.");
                } else {
                    System.out.printf("Incorrect identity, because %f != 0%n.", c);
                }
            } else {
                double root = -c / b;
                System.out.printf("The equation is linear, x = -c / b = %f", root);
            }
        } else {
            double discriminant = Math.pow(b, 2) - 4 * a * c;
            final double epsilon = 1.0E-10;

            if (discriminant > epsilon) {
                double equationRoot1 = (-b - Math.sqrt(discriminant)) / (2 * a);
                double equationRoot2 = (-b + Math.sqrt(discriminant)) / (2 * a);
                System.out.printf("The equation has two roots: x1 = %f, x2 = %f", equationRoot1, equationRoot2);
            } else if (Math.abs(discriminant) <= epsilon) {
                double equationRoot = -b / (2 * a);
                System.out.printf("The equation has one root x = %f", equationRoot);
            } else {
                System.out.println("The equation has no roots.");
            }
        }
    }
}
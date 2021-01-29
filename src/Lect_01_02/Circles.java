package Lect_01_02;

import java.util.Scanner;

public class Circles {
    public static void main(String[] args) {
        System.out.println("Tasks available:");
        System.out.println("1 - Calculate circle area and length using radius provided");
        System.out.println("2 - Calculate circle sector area using radius and sector's angle provided");
        System.out.println("3 - Calculate radius using circle area provided");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a task number: ");
        int taskId = scanner.nextInt();

        if (taskId == 1) {
            System.out.print("Enter radius: ");
            double radius = scanner.nextDouble();

            System.out.printf("Circle area is %.3f, length is %.3f%n", getCircleArea(radius), getCircleLength(radius));
        } else if (taskId == 2) {
            System.out.print("Enter radius: ");
            double radius = scanner.nextDouble();

            System.out.print("Enter angle in degrees (from 1 to 360): ");
            double sectorAngleInDegrees = Math.abs(scanner.nextDouble()); // Math.abs in case of negative angles

            System.out.printf("Sector area is: %.3f%n", getSectorArea(radius, sectorAngleInDegrees));
        } else if (taskId == 3) {
            System.out.print("Enter area of a circle: ");
            double circleArea = scanner.nextDouble();

            System.out.printf("Radius of the circle is: %.3f", getCircleRadius(circleArea));
        } else {
            System.out.print("Task with this number is not available.");
        }
    }

    public static double getCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double getCircleLength(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double getCircleRadius(double circleArea) {
        return Math.pow(circleArea / Math.PI, 0.5);
    }

    public static double getSectorArea(double radius, double angleInDegrees) {
        return Math.pow(radius, 2) * Math.toRadians(angleInDegrees) / 2;
    }
}
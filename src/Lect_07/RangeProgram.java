package Lect_07;

import java.util.Scanner;

public class RangeProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Setting a range ***");
        System.out.print("Enter the left bound: ");
        double leftBound = scanner.nextDouble();

        System.out.print("Enter the right bound: ");
        double rightBound = scanner.nextDouble();

        RangeClass range = new RangeClass(leftBound, rightBound);
        System.out.printf("Length of the range is %.3f%n", range.getRangeLenght());

        System.out.print("Enter a point: ");
        double point = scanner.nextDouble();

        if (range.isInside(point)) {
            System.out.println("The point is within the range.");
        } else {
            System.out.println("The point is out of the range.");
        }
    }
}
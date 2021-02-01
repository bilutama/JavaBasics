package JavaCourseTasks;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        System.out.println("*** Calculates area of a triangle ***");

        Scanner scanner = new Scanner(System.in);

        // Array to store 3 points with X and Y as [dimension][pointCounter]
        double[][] points = new double[3][2];

        System.out.println("Please enter coordinates:");

        for (int i = 0; i < points.length; ++i) {
            System.out.printf("X for point #%d: ", i + 1);
            points[i][0] = scanner.nextDouble();

            System.out.printf("Y for point #%d: ", i + 1);
            points[i][1] = scanner.nextDouble();
        }

        double deltaX1MultipleDeltaY2 = Math.abs((points[0][1] - points[1][1]) * (points[0][0] - points[2][0]));
        double deltaX2MultipleDeltaY1 = Math.abs((points[0][1] - points[2][1]) * (points[0][0] - points[1][0]));

        final double epsilon = 1.0E-10;
        // Check if the points are on the line and calculate the area otherwise
        if (Math.abs(deltaX1MultipleDeltaY2 - deltaX2MultipleDeltaY1) <= epsilon) {
            System.out.println("All the vertices of the triangle are on the same line, i.e. area = 0");
        } else {
            double triangleSide1 = Math.sqrt(Math.pow((points[0][0] - points[1][0]), 2) +
                    Math.pow((points[0][1] - points[1][1]), 2));
            double triangleSide2 = Math.sqrt(Math.pow((points[0][0] - points[2][0]), 2) +
                    Math.pow((points[0][1] - points[2][1]), 2));
            double triangleSide3 = Math.sqrt(Math.pow((points[1][0] - points[2][0]), 2) +
                    Math.pow((points[1][1] - points[2][1]), 2));

            double triangleSemiPerimeter = (triangleSide1 + triangleSide2 + triangleSide3) / 2;

            double triangleArea = Math.sqrt(triangleSemiPerimeter *
                    (triangleSemiPerimeter - triangleSide1) *
                    (triangleSemiPerimeter - triangleSide2) *
                    (triangleSemiPerimeter - triangleSide3));

            System.out.printf("Area if the triangle is %.3f: ", triangleArea);
        }
    }
}
package JavaCourseTasks;

import java.util.Scanner;

public class TriangleArea2 {
    public static void main(String[] args) {
        System.out.println("*** Calculates area of a triangle ***");

        Scanner scanner = new Scanner(System.in);

        // Array to store 3 points with X and Y as [dimension][pointCount]
        double[][] points = new double[2][3];

        System.out.println("Please enter coordinates:");

        for (int i = 0; i < points.length; ++i) {
            double temporaryCoordinateX;
            double temporaryCoordinateY;

            System.out.printf("X for point #%d: ", i + 1);
            temporaryCoordinateX = scanner.nextDouble();

            System.out.printf("Y for point #%d: ", i + 1);
            temporaryCoordinateY = scanner.nextDouble();

            points[0][i] = temporaryCoordinateX;
            points[1][i] = temporaryCoordinateY;
        }

        double tangentOfSegment1 = Math.abs(points[1][0] - points[1][1]) /
                Math.abs(points[0][0] - points[0][1]);
        double tangentOfSegment2 = Math.abs(points[1][0] - points[1][2]) /
                Math.abs(points[0][0] - points[0][2]);

        // Check if the points are on the line and calculate the area otherwise
        if (tangentOfSegment1 == tangentOfSegment2) {
            System.out.println("All the vertices of the triangle are on the same line, i.e. area = 0");
        } else {
            double triangleSide1 = Math.sqrt(Math.pow((points[0][0] - points[0][1]), 2) +
                    Math.pow((points[1][0] - points[1][1]), 2));
            double triangleSide2 = Math.sqrt(Math.pow((points[0][0] - points[0][2]), 2) +
                    Math.pow((points[1][0] - points[1][2]), 2));
            double triangleSide3 = Math.sqrt(Math.pow((points[0][1] - points[0][2]), 2) +
                    Math.pow((points[1][1] - points[1][2]), 2));

            double triangleSemiPerimeter = (triangleSide1 + triangleSide2 + triangleSide3) / 2;

            double areaOfTriangle = Math.sqrt((triangleSemiPerimeter) *
                    (triangleSemiPerimeter - triangleSide1) *
                    (triangleSemiPerimeter - triangleSide2) *
                    (triangleSemiPerimeter - triangleSide3));

            System.out.printf("Area if the triangle is %.3f: ", areaOfTriangle);
        }
    }
}
package JavaCourseTasks;

import Lect_01_02.CartesianGridPoint;

import java.util.Scanner;

public class TriangleAreaTemp {
    public static void main(String[] args) {
        System.out.println("*** Calculates area of a triangle ***");

        Scanner scanner = new Scanner(System.in);

        CartesianGridPoint[] points = new CartesianGridPoint[3];

        System.out.println("Please enter coordinates:");

        for (int i = 0; i < points.length; ++i) {
            double temporaryCoordinateX;
            double temporaryCoordinateY;

            System.out.printf("X for point #%d: ", i + 1);
            temporaryCoordinateX = scanner.nextDouble();

            System.out.printf("Y for point #%d: ", i + 1);
            temporaryCoordinateY = scanner.nextDouble();

            points[i] = new CartesianGridPoint(temporaryCoordinateX, temporaryCoordinateY);
        }

        double tangentOfSegment1 = Math.abs(points[0].getX() - points[1].getX()) /
                Math.abs(points[0].getY() - points[1].getY());
        double tangentOfSegment2 = Math.abs(points[0].getX() - points[2].getX()) /
                Math.abs(points[0].getY() - points[2].getY());

        // Check if the points are on the line and calculate the area otherwise
        if (tangentOfSegment1 == tangentOfSegment2) {
            System.out.println("All the vertices of the triangle are on the same line, i.e. area = 0");
        } else {
            double triangleSide1 = Math.sqrt(Math.pow((points[0].getX() - points[1].getX()), 2) +
                    Math.pow((points[0].getY() - points[1].getY()), 2));
            double triangleSide2 = Math.sqrt(Math.pow((points[0].getX() - points[2].getX()), 2) +
                    Math.pow((points[0].getY() - points[2].getY()), 2));
            double triangleSide3 = Math.sqrt(Math.pow((points[1].getX() - points[2].getX()), 2) +
                    Math.pow((points[1].getY() - points[2].getY()), 2));

            double triangleSemiPerimeter = (triangleSide1 + triangleSide2 + triangleSide3) / 2;

            double areaOfTriangle = Math.sqrt((triangleSemiPerimeter) *
                    (triangleSemiPerimeter - triangleSide1) *
                    (triangleSemiPerimeter - triangleSide2) *
                    (triangleSemiPerimeter - triangleSide3));

            System.out.printf("Area if the triangle is %.3f: ", areaOfTriangle);
        }
    }
}
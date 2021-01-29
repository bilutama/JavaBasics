package HomeTasks;/*
Searches a pair of closest points among a set of three.
Input: X and Y coordinates of three points.
Output: Closest points (#1 and #2, for example) and distance between them.
*/

import java.util.Scanner;

public class ClosestPoints {
    public static void main(String[] args) {
        System.out.printf("*** Determines two closest points among a set of three. ***%n");
        System.out.print("*** In case of several pairs are acceptable, ");
        System.out.printf("for example for isosceles triangle, only the first pair will be printed. ***%n");

        // TODO: implement multiple points analysis (input and pairs output)
        // Reading points' coordinates from the Console
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

        // Searching for the minimum distance
        double minimumDistance = Double.MAX_VALUE;
        int selectedPoint1 = -1;
        int selectedPoint2 = -1;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = getDistanceBetweenTwoPoints(points[i], points[j]);

                if (distance < minimumDistance) {
                    minimumDistance = distance;
                    selectedPoint1 = i + 1;
                    selectedPoint2 = j + 1;
                }
            }
        }

        System.out.printf("Shortest distance is %.3f between points #%d and #%d", minimumDistance, selectedPoint1, selectedPoint2);
    }

    /**
     * Returns distance between two points (determined as <code>{@link CartesianGridPoint}</code>).
     *
     * @param point1 as <code>{@link CartesianGridPoint}</code>.
     * @param point2 as <code>{@link CartesianGridPoint}</code>.
     */
    public static double getDistanceBetweenTwoPoints(CartesianGridPoint point1, CartesianGridPoint point2) {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }
}
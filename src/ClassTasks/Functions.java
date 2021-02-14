package ClassTasks;

import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        double x = scanner.nextDouble();

        System.out.print("Enter y: ");
        double y = scanner.nextDouble();

        System.out.printf("3x + 4y = %.3f%n", getSum3XAnd4Y(x, y));
        System.out.printf("Minimum is %.3f%n", getMinimum(x, y));
        System.out.printf("Maximum is %.3f%n", getMaximum(x, y));

        System.out.printf("158 + 365 = %.3f%n", getSum3XAnd4Y(158.0, 365.0));

        x = 1654631223;
        y = -85503546;
        System.out.printf("sum of %.3f and %.3f is %.3f%n", x, y, getSum3XAnd4Y(x, y));
        System.out.printf("Minimum is %.3f%n", getMinimum(x, y));
        System.out.printf("Maximum is %.3f%n", getMaximum(x, y));

        System.out.print("Enter a: ");
        int a = scanner.nextInt();

        System.out.print("Enter b: ");
        int b = scanner.nextInt();

        System.out.printf("Average for the sum from %d to %d is %.3f%n", a, b, getAverageForRange(a, b));
    }

    public static double getSum3XAnd4Y(double x, double y) {
        return 3.0 * x + 4.0 * y;
    }

    public static double getAverageForRange(int begin, int end) {
        int sumForRange = 0;

        int min = getMinimum(begin, end);
        int max = getMaximum(begin, end);

        for (int i = min; i <= max; ++i) {
            sumForRange += i;
        }

        return (double) sumForRange / (max - min + 1);
    }

    public static int getMinimum(int x, int y) {
        return (x < y) ? x : y;
    }

    public static int getMaximum(int x, int y) {
        return (x >= y) ? x : y;
    }

    public static double getMinimum(double x, double y) {
        return (x < y) ? x : y;
    }

    public static double getMaximum(double x, double y) {
        return (x >= y) ? x : y;
    }
}
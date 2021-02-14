package ClassTasks;

import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        int x = scanner.nextInt();

        System.out.print("Enter y: ");
        int y = scanner.nextInt();

        System.out.printf("x + y = %d%n", getSum(x, y));
        System.out.printf("Minimum is %d%n", getMinimum(x, y));
        System.out.printf("Maximum is %d%n", getMaximum(x, y));

        System.out.printf("158 + 365 = %d%n", getSum(158, 365));

        x = 1654631223;
        y = -85503546;
        System.out.printf("sum of %d and %d is %d%n", x, y, getSum(x, y));
        System.out.printf("Minimum is %d%n", getMinimum(x, y));
        System.out.printf("Maximum is %d%n", getMaximum(x, y));
    }

    public static long getSum(int x, int y) {
        return x + y;
    }

    public static long getSumForRange(int begin, int end) {
        int sumForRange = 0;

        for (int i = begin; i <= end; ++i) {
            sumForRange += i;
        }

        return sumForRange;
    }

    public static int getMinimum(int x, int y) {
        return (x < y) ? x : y;
    }

    public static int getMaximum(int x, int y) {
        return (x > y) ? x : y;
    }
}
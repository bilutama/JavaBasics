package Lect_09;

public class MaximumInArray {
    public static void main(String[] args) {
        double[] array = new double[]{1.4, 2.5, 3.7, 4.3, 10.9, 5.3, 6.3, 7.6, 8.1, 5.2};

        System.out.println("Array is:");
        printArray(array);
        System.out.printf("It's maximum element is %.1f", getMaximumIndex(array));
    }

    public static double getMaximumIndex(double[] array) {
        double max = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static void printArray(double[] array) {
        for (double number : array) {
            System.out.printf("%.1f ", number);
        }

        System.out.println();
    }
}
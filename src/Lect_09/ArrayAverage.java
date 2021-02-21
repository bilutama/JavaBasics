package Lect_09;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] array1 = new int[]{};
        int[] array2 = new int[]{1, 2, 3, 4, 10, 5, 6, 7, 8, 5};

        System.out.printf("%.3f%n", getAverage(array1));
        System.out.printf("%.3f%n", getAverage(array2));
    }

    public static double getAverage(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int sum = 0;

        for (int j : array) {
            sum += j;
        }

        return (double) sum / array.length;
    }
}
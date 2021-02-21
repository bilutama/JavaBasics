package Lect_09;

public class StringsArrayToUpperCase {
    public static void main(String[] args) {
        double[] array = new double[]{1.5, 2.3, 3.2, 4.8, 10.6, 5.4, 6.1, 7.9, 8.3, 9.5};

        double max = Double.MIN_VALUE;
        for (double i : array) {
            if (i > max) {
                max = i;
            }
        }

        System.out.printf("Maximum value in the array is %.3f%n", max);
    }
}
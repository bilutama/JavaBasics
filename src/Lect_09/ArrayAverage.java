package Lect_09;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] array1 = {};
        int[] array2 = {5, 3, 1};
        int[] array3 = {1, 2, 3, 4, 10, 5, 6, 7, 8, 5};

        System.out.printf("%.3f%n", getEvenNumbersAverage(array1));
        System.out.printf("%.3f%n", getEvenNumbersAverage(array2));
        System.out.printf("%.3f%n", getEvenNumbersAverage(array3));
    }

    public static double getEvenNumbersAverage(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int evenNumbersSum = 0;
        int evenNumbersCounter = 0;

        for (int number : array) {
            if (number % 2 == 0) {
                evenNumbersSum += number;
                ++evenNumbersCounter;
            }
        }

        if (evenNumbersCounter == 0) {
            return 0;
        }

        return (double) evenNumbersSum / evenNumbersCounter;
    }
}
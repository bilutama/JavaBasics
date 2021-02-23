package Lect_09;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] array1 = {100, 55, 3, 2, 1, 0};
        int[] array2 = {1, 2, 3, 10, 50, 55, 600};
        int[] array3 = {15, 2, 5, 16, 100, 0, 600};

        System.out.printf("Array1 is sorted in ascending order: %s%n", isSortedAscendingOrder(array1));
        System.out.printf("Array2 is sorted in ascending order: %s%n", isSortedAscendingOrder(array2));
        System.out.printf("Array3 is sorted in ascending order: %s%n", isSortedAscendingOrder(array3));

        System.out.printf("Array1 is sorted in descending order: %s%n", isSortedDescendingOrder(array1));
        System.out.printf("Array2 is sorted in descending order: %s%n", isSortedDescendingOrder(array2));
        System.out.printf("Array3 is sorted in descending order: %s%n", isSortedDescendingOrder(array3));
    }

    public static boolean isSortedAscendingOrder(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSortedDescendingOrder(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
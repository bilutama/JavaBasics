package SortingAlgorithms;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 80, 3, 4, 100, 10, 30, 16, 13, 25, 9};

        System.out.println("*** Quick Sort ***");
        System.out.println("The initial array:");
        printArray(array);

        sortArray(array, 0, array.length - 1);

        System.out.println("The sorted array:");
        printArray(array);
    }

    private static void sortArray(int[] array, int left, int right) {
        if (right - left < 2) {
            return;
        }

        int referenceValue = array[left]; // Can be any element of the (sub)array
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < referenceValue) {
                ++i;
            }

            while (array[j] > referenceValue) {
                --j;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                ++i;
                --j;
            }
        }

        if (i < right) {
            sortArray(array, i, right);
        }

        if (j > left) {
            sortArray(array, left, j);
        }
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.printf("%4d", element);
        }

        System.out.println();
    }
}
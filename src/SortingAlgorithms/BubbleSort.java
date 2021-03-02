package SortingAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 80, 3, 4, 100, 10, 30, 16, 13, 25, 9};

        System.out.println("*** Bubble Sort ***");
        System.out.println("The initial array:");
        printArray(array);

        sortArray(array);

        System.out.println("The sorted array:");
        printArray(array);
    }

    private static void sortArray(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            boolean isSorted = true;

            for (int j = 0; j < array.length - i; ++j) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.printf("%4d", element);
        }

        System.out.println();
    }
}
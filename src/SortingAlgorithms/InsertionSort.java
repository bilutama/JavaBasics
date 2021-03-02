package SortingAlgorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 80, 3, 4, 100, 10, 30, 16, 13, 25, 9};

        System.out.println("*** Insertion Sort ***");
        System.out.println("The initial array:");
        printArray(array);

        sortArray(array);

        System.out.println("The sorted array:");
        printArray(array);
    }

    private static void sortArray(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            if (array[i - 1] > array[i]) {
                int j = i - 1;
                int temp = array[i];

                do {
                    array[j + 1] = array[j];
                    --j;
                } while (j >= 0 && temp < array[j]);

                array[j + 1] = temp;
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
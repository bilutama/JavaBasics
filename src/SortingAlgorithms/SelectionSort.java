package SortingAlgorithms;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {100, 1, 2, 5, 80, 3, 4, 10, 30, 16, 13, 25, 9};

        System.out.println("*** Selection Sort ***");
        System.out.println("The initial array:");
        printArray(array);

        sortArray(array);

        System.out.println("The sorted array:");
        printArray(array);
    }

    private static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minimumElementIndex = i;

            for (int j = minimumElementIndex + 1; j < array.length; ++j) {
                if (array[j] < array[minimumElementIndex]) {
                    minimumElementIndex = j;
                }
            }

            int temp = array[minimumElementIndex];
            array[minimumElementIndex] = array[i];
            array[i] = temp;
        }
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.printf("%4d", element);
        }

        System.out.println();
    }
}
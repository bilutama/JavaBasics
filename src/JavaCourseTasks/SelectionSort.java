package JavaCourseTasks;

public class SelectionSort {
    public static void main(String[] args) {
        final int arraySize = 10;
        int[] array = new int[arraySize];

        // Array initialization
        for (int i = 0; i < arraySize; ++i) {
            array[i] = arraySize - i;
        }

        System.out.println("The initial array:");
        printArray(array);

        sortArray(array);

        System.out.println("The sorted array:");
        printArray(array);
    }

    private static void sortArray(int[] array) {
        if (array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (array[i] > array[minIndex]) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%4d", i);
        }

        System.out.println();
    }
}
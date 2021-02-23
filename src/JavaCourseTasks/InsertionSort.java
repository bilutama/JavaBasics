package JavaCourseTasks;

public class InsertionSort {
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
            if (array[i + 1] < array[i]) {
                int j = i;

                while (j >= 0 && array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    --j;
                    //printArray(array); // For debugging
                }
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
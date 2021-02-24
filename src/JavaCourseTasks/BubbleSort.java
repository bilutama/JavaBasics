package JavaCourseTasks;

public class BubbleSort {
    public static void main(String[] args) {
        final int arraySize = 30;
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

        for (int i = 1; i < array.length; ++i) {
            boolean isSorted = true;

            for (int j = 0; j < array.length - i; ++j) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                printArray(array);

                if (isSorted) {
                    break;
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
package JavaCourseTasks;

public class SelectionSort {
    public static void main(String[] args) {
        final int arraySize = 20;
        int[] array = new int[arraySize];

        // Array initialization
        for (int i = 0; i < arraySize; ++i) {
            array[i] = arraySize - i;
        }

        System.out.println("The initial array:");
        printArray(array);

        // sorting the array
        for (int i = 0; i < arraySize - 1; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < arraySize; ++j) {
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

        System.out.println("The sorted array:");
        printArray(array);
    }

    static private void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%4d", i);
        }

        System.out.println();
    }
}
package JavaCourseTasks;

public class InsertionSort {
    public static void main(String[] args) {
        final int arraySize = 5;
        int[] array = new int[arraySize];

        // Array initialization
        for (int i = 0; i < arraySize; ++i) {
            array[i] = arraySize - i;
        }

        System.out.println("The initial array:");
        printArray(array);

        // TODO: rewrite algorithm. This is insertion sort
        // sorting the array
        for (int i = 0; i < arraySize - 1; ++i) {
            if (array[i + 1] < array[i]) {
                int j = i;

                while (j >= 0 && array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    --j;
                    //printArray(array); // Monitoring while debugging
                }
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

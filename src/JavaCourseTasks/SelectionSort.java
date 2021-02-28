package JavaCourseTasks;

public class SelectionSort {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 20;
        int[] array = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; ++i) {
            array[i] = ARRAY_SIZE - i;
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
            int minimumElementIndex = getMinimumElementIndexOnArrayTail(array, i);

            if (array[i] > array[minimumElementIndex]) {
                int temp = array[minimumElementIndex];
                array[minimumElementIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    private static int getMinimumElementIndexOnArrayTail(int[] array, int start) {
        if (start >= array.length - 1) {
            return array.length - 1;
        }

        int minimumElementIndex = start;

        for (int j = minimumElementIndex + 1; j < array.length; ++j) {
            if (array[j] < array[minimumElementIndex]) {
                minimumElementIndex = j;
            }
        }

        return minimumElementIndex;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%4d", i);
        }

        System.out.println();
    }
}
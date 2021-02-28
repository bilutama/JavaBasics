package JavaCourseTasks;

public class InsertionSort {
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
            if (array[i] > array[i + 1]) {
                int j = i;

                do {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    --j;
                } while (j >= 0 && array[j] > array[j + 1]);
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
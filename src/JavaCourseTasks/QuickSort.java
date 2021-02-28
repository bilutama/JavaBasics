package JavaCourseTasks;

public class QuickSort {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 20;
        int[] array = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; ++i) {
            array[i] = ARRAY_SIZE - i;
        }

        System.out.println("The initial array:");
        printArray(array);

        sortArray(array, 0, array.length - 1);

        System.out.println("The sorted array:");
        printArray(array);
    }

    private static void sortArray(int[] array, int left, int right) {
        if (array.length < 2) {
            return;
        }

        int referenceValue = array[left]; // Maybe any element of the (sub)array
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < referenceValue) {
                ++i;
            }

            while (array[j] > referenceValue) {
                --j;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                ++i;
                --j;
            }
        }

        if (i < right) {
            sortArray(array, i, right);
        }

        if (j > left) {
            sortArray(array, left, j);
        }
    }

    static private void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%4d", i);
        }

        System.out.println();
    }
}
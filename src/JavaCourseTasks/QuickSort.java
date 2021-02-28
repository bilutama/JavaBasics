package JavaCourseTasks;

public class QuickSort {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 15;
        int[] array = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; ++i) {
            array[i] = ARRAY_SIZE - i;
        }

        //int[] array = {4, 1, 3, 2};

        System.out.println("The initial array:");
        printArray(array);

        System.out.println("Sorting:");
        sortArray(array, 0, array.length - 1);

        System.out.println("The sorted array:");
        printArray(array);
    }

    private static void sortArray(int[] array, int left, int right) {
        //int reference = left + (right - left) / 2;
        int reference = array[left + (right - left) / 2];

        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < reference) {
                ++i;
            }

            while (array[j] > reference) {
                --j;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                ++i;
                --j;
                //printArray(array);
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
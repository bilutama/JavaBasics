package JavaCourseTasks;

public class SelectionSort {
    public static void main(String[] args) {
        final int arraySize = 20;
        int[] array = new int[arraySize];

        // Array initialization
        for (int i = 0; i < arraySize; ++i) {
            array[i] = arraySize - i;
        }

        // printing the array
        System.out.println("The initial array:");

        for (int i : array) {
            System.out.printf("%3d", i);
        }

        System.out.println();

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

        // printing the sorted array
        System.out.println("The sorted array:");

        for (int i : array) {
            System.out.printf("%3d", i);
        }
    }
}
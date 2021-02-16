package JavaCourseTasks;

public class HeapSort {
    public static void main(String[] args) {
        final int arraySize = 10;
        int[] array = new int[arraySize];

        // Array initialization
        for (int i = 0; i < arraySize; ++i) {
            //array[i] = arraySize - i;
            array[i] = i + 1;
        }

        // printing the array
        System.out.println("The initial array:");

        for (int i : array) {
            System.out.printf("%3d", i);
        }

        System.out.println();

        // Build a heap from the array
        for (int i = arraySize / 2 - 1; i >= 0; --i) {

            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            int max = i;

            if (leftChild < arraySize && array[leftChild] > array[i]) {
                max = leftChild;
            }

            if (rightChild < arraySize && array[rightChild] > array[max]) {
                max = rightChild;
            }

            // move max element to the root
            if (i != max) {
                int temp = array[max];
                array[max] = array[i];
                array[i] = temp;
            }

        }

        for (int i : array) {
            System.out.printf("%3d", i);
        }

        // Sort the heap recursively

    }
}

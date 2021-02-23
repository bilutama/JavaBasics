package JavaCourseTasks;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{15, 9, 18, 1, 3, 2, 17, 5, 7, 8, 50, 4, 100, 121, 16, 32, 65, 76, 44, 51};

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

        for (int i = 0; i < array.length; ++i) {
            buildHeap(array, 0, array.length - i);
            //printArray(array); // For monitoring while debugging

            int temp = array[0];
            array[0] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    static private void buildHeap(int[] array, int heapRoot, int heapLength) {
        for (int i = heapLength / 2 - 1; i >= heapRoot; --i) {

            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            int maximum = i;

            if (leftChild < heapLength && array[leftChild] > array[i]) {
                maximum = leftChild;
            }

            if (rightChild < heapLength && array[rightChild] > array[maximum]) {
                maximum = rightChild;
            }

            // Move the maximum element to the root and recursively sift the heap down to leaves
            if (i != maximum) {
                int temp = array[maximum];
                array[maximum] = array[i];
                array[i] = temp;

                buildHeap(array, maximum, heapLength);
            }
        }
    }

    static private void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%4d", i);
        }

        System.out.println();
    }
}
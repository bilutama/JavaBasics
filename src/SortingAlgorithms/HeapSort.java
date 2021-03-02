package SortingAlgorithms;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 80, 3, 4, 100, 10, 30, 16, 13, 25, 9};

        System.out.println("*** Heap Sort ***");
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

            // Move the maximum element to the root and recursively sift down
            if (i != maximum) {
                int temp = array[maximum];
                array[maximum] = array[i];
                array[i] = temp;

                buildHeap(array, maximum, heapLength);
            }
        }
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.printf("%4d", element);
        }

        System.out.println();
    }
}
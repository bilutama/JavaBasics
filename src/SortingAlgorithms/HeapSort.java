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
        // 1 STAGE - initializing a heap on the array
        buildHeap(array);

        // 2 STAGE - swap the first and the last elements of the heap
        // and rebuild the reduced heap sifting down the new root
        for (int i = 0; i < array.length; ++i) {
            int temp = array[0];
            array[0] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;

            siftHeapElementDown(array, 0, array.length - i - 1);
        }
    }

    private static void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; --i) {
            siftHeapElementDown(array, i, array.length);
        }
    }

    private static void siftHeapElementDown(int[] array, int heapRoot, int heapLength) {
        int currentRoot = heapRoot;
        int maximumElementIndex = heapRoot;

        while (true) {
            int leftChildIndex = 2 * currentRoot + 1;
            int rightChildIndex = 2 * currentRoot + 2;

            if (leftChildIndex < heapLength && array[leftChildIndex] > array[currentRoot]) {
                maximumElementIndex = leftChildIndex;
            }

            if (rightChildIndex < heapLength && array[rightChildIndex] > array[maximumElementIndex]) {
                maximumElementIndex = rightChildIndex;
            }

            if (currentRoot == maximumElementIndex) {
                break;
            } else {
                int temp = array[maximumElementIndex];
                array[maximumElementIndex] = array[currentRoot];
                array[currentRoot] = temp;

                currentRoot = maximumElementIndex;
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
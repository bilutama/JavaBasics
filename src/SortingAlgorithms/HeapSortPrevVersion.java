package SortingAlgorithms;

public class HeapSortPrevVersion {
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

            int maximumElementIndex = i;

            if (leftChild < heapLength && array[leftChild] > array[i]) {
                maximumElementIndex = leftChild;
            }

            if (rightChild < heapLength && array[rightChild] > array[maximumElementIndex]) {
                maximumElementIndex = rightChild;
            }

            // Move the maximumElementIndex element to the root and recursively sift down
            if (i != maximumElementIndex) {
                int temp = array[maximumElementIndex];
                array[maximumElementIndex] = array[i];
                array[i] = temp;

                buildHeap(array, maximumElementIndex, heapLength);
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
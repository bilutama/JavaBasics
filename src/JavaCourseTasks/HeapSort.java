package JavaCourseTasks;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{15,9,18,1,3,2,17,5,7,8,50,4,100,121,16,32,65,76,44,51};

        // printing the initial array
        System.out.println("The initial array:");
        printArray(array);
        System.out.println();

        for (int i = 0; i < array.length; ++i) {
            array = buildHeap(array, 0, array.length - i);
            printArray(array);

            int temp = array[0];
            array[0] = array [array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    static private int[] buildHeap(int[] array, int k, int n) {

        for (int i = n / 2 - 1; i >= k; --i) {

            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            int max = i;

            if (leftChild < n && array[leftChild] > array[i]) {
                max = leftChild;
            }

            if (rightChild < n && array[rightChild] > array[max]) {
                max = rightChild;
            }

            // move max element to the root and recursively check down the heap
            if (i != max) {
                int temp = array[max];
                array[max] = array[i];
                array[i] = temp;

                array = buildHeap(array, max, n);
            }
        }
        return array;
    }

    static private void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%4d", i);
        }

        System.out.println();
    }
}
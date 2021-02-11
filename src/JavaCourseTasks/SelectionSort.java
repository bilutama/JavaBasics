package JavaCourseTasks;

public class SelectionSort {
    public static void main(String[] args) {
        final int arraySize = 10;
        int[] array = new int[arraySize];

        // Array initialization
        for (int i = 0; i < arraySize; ++i) {
            array[i] = 2 * (i + 1);
        }

        // printing the array;
        final int numbersCountInRow = 10;
        System.out.println("The array is:");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%4d", array[i]);

            if ((i + 1) % numbersCountInRow == 0) {
                System.out.println();
            }
        }
    }
}

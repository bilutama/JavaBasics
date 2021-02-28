package JavaCourseTasks;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int ARRAY_SIZE = 30;
        int[] array = new int[ARRAY_SIZE];

        // Array initialization
        for (int i = 0; i < ARRAY_SIZE; ++i) {
            array[i] = 2 * (i + 1);
        }

        System.out.println("The array is:");
        printArray(array);

        System.out.print("Enter a number to find: ");
        int number = scanner.nextInt();

        System.out.printf("Number's index is %d%n", getElementIndex(array, number));
    }

    public static int getElementIndex(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;

        while (right >= left) {
            int middle = left + (right - left) / 2;

            if (array[middle] > number) {
                right = middle - 1;
            } else if (array[middle] < number) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void printArray(int[] array) {
        for (int number : array) {
            System.out.printf("%4d", number);
        }

        System.out.println();
    }
}
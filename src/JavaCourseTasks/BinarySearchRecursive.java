package JavaCourseTasks;

import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int ARRAY_SIZE = 30;
        int[] array = new int[ARRAY_SIZE];

        // Array initialization
        for (int i = 0; i < ARRAY_SIZE; ++i) {
            array[i] = 2 * (i + 1);
        }

        // printing the array;
        System.out.println("The array is:");
        printArray(array);

        System.out.print("Enter a number to find: ");
        int number = scanner.nextInt();

        System.out.printf("Number's position is %d%n", getElementIndex(array, 0, array.length, number));
    }

    private static int getElementIndex(int[] array, int left, int right, int number) {
        int middle = left + (right - left) / 2;

        if ((array[middle] < number) && right > left) {
            return getElementIndex(array, middle + 1, right, number);
        } else if ((array[middle] > number) && right > left) {
            return getElementIndex(array, left, middle - 1, number);
        } else {
            if (array[middle] == number) {
                return middle;
            }

            return -1;
        }
    }

    public static void printArray(int[] array) {
        for (int number : array) {
            System.out.printf("%4d", number);
        }

        System.out.println();
    }
}
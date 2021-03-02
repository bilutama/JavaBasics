package JavaCourseTasks;

import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = {1, 3, 5, 7, 9, 11, 13, 14, 15, 16, 18, 20, 22};

        System.out.println("The array is:");
        printArray(array);

        System.out.print("Enter a number to find: ");
        int number = scanner.nextInt();

        System.out.printf("Number's index is %d%n", getElementIndex(array, 0, array.length - 1, number));
    }

    private static int getElementIndex(int[] array, int left, int right, int number) {
        if (left > right) {
            return -1;
        }

        int middle = left + (right - left) / 2;

        if (array[middle] < number) {
            return getElementIndex(array, middle + 1, right, number);
        }

        if (array[middle] > number) {
            return getElementIndex(array, left, middle - 1, number);
        }

        return middle;
    }

    public static void printArray(int[] array) {
        for (int number : array) {
            System.out.printf("%4d", number);
        }

        System.out.println();
    }
}
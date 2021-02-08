package JavaCourseTasks;

import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int arraySize = 100;
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

        System.out.print("Enter a number to find: ");
        int userNumber = scanner.nextInt();

        int leftBound = 0;
        int rightBound = array.length - 1;

        int position = getNumberPositionInArray(array, leftBound, rightBound, userNumber);

        if (position != -1) {
            System.out.printf("Position in array is %d%n", position);
        } else {
            System.out.println("Number is not found");
        }
    }

    private static int getNumberPositionInArray(int[] array, int leftBound, int rightBound, int numberToFind) {
        int middlePosition = leftBound + (rightBound - leftBound) / 2;

        if ((array[middlePosition] < numberToFind) && (rightBound - leftBound > 1)) {
            return getNumberPositionInArray(array, middlePosition + 1, rightBound, numberToFind);
        } else if ((array[middlePosition] > numberToFind) && (rightBound - leftBound > 1)) {
            return getNumberPositionInArray(array, leftBound, middlePosition - 1, numberToFind);
        } else {
            if (array[middlePosition] == numberToFind) {
                return middlePosition + 1;
            } else if (array[rightBound] == numberToFind) {
                return rightBound + 1;
            } else {
                return -1;
            }
        }
    }
}
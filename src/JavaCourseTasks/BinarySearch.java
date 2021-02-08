package JavaCourseTasks;

import java.util.Scanner;

public class BinarySearch {
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

        boolean foundNumberPosition = false;
        int leftBound = 0;
        int rightBound = array.length - 1;
        //int middlePosition = (rightBound + leftBound) / 2;

        while (!foundNumberPosition) {
            int middlePosition = leftBound + (rightBound - leftBound) / 2;

            if ((array[middlePosition] > userNumber) && (rightBound - leftBound) > 1) {
                rightBound = middlePosition - 1;
            } else if ((array[middlePosition] < userNumber) && (rightBound - leftBound) > 1) {
                leftBound = middlePosition + 1;
            } else {
                foundNumberPosition = true;

                if (array[middlePosition] == userNumber) {
                    System.out.printf("The number has %d position in the array.%n", middlePosition + 1);
                } else if (array[rightBound] == userNumber) {
                    System.out.printf("The number has %d position in the array.%n", rightBound + 1);
                } else {
                    System.out.println("The number is not in the array.");
                }
            }
        }
    }
}
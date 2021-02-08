package JavaCourseTasks;

import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int arraySize = 100;
        int[] array = new int[arraySize];

        Random randomNumber = new Random();

        // Array initialization with random numbers
        for (int i = 0; i < arraySize; ++i) {
            if (i < 50) {
                array[i] = i;
            } else {
                array[i] = i + 1;
            }
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

        int numberPositionInArray;
        boolean foundNumberPosition = false;
        int leftBound = 0;
        int rightBound = array.length;
        //int middlePosition = (rightBound + leftBound) / 2;

        while (!foundNumberPosition) {
            int middlePosition = leftBound + (rightBound - leftBound) / 2;

            if (array[middlePosition] > userNumber) {
                rightBound = middlePosition - 1;
            } else if (array[middlePosition] < userNumber) {
                leftBound = middlePosition + 1;
            } else {
                numberPositionInArray = middlePosition;
                foundNumberPosition = true;

                if (array[middlePosition] == userNumber) {
                    System.out.printf("Your number has %d position in the array.", numberPositionInArray);
                } else {
                    System.out.printf("Your number is not in the array. Closest is %d with %d position in the array.%n", array[numberPositionInArray], numberPositionInArray);
                }
            }
        }
    }
}
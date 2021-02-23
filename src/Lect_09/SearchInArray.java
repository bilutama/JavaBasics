package Lect_09;

import java.util.Scanner;

public class SearchInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = {1, 2, 3, 4, 10, 5, 6, 7, 8, 5};

        System.out.print("Enter a number to find it in the array: ");
        int number = scanner.nextInt();

        System.out.printf("It's index is %d%n", getIndexInArray(array, number));

        System.out.println("The whole array is:");
        printArray(array);
    }

    public static int getIndexInArray(int[] array, int number) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == number) {
                return i;
            }
        }

        return -1;
    }

    public static void printArray(int[] array) {
        for (int number : array) {
            System.out.printf("%d ", number);
        }

        System.out.println();
    }
}
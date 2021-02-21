package Lect_09;

import java.util.Scanner;

public class MaximumInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[]{1, 2, 3, 4, 10, 5, 6, 7, 8, 5};

        System.out.print("Enter a number to find in the array: ");
        int number = scanner.nextInt();

        System.out.println(getIndexInArray(array, number));
    }

    public static int getIndexInArray(int[] array, int number) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == number) {
                return i;
            }
        }

        return -1;
    }
}
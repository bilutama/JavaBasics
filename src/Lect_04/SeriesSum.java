package Lect_04;

import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        System.out.println("*** Calculates sum of the series 1 - 4 + 9 - 16 + 25 ... ***");

        Scanner scanner = new Scanner(System.in);

        int seriesIndex = -1;
        while (seriesIndex < 0) {
            System.out.print("Enter series index: ");
            seriesIndex = scanner.nextInt();
        }

        int seriesSumByIndex = 0;
        for (int i = 1; i <= seriesIndex; ++i) {
            seriesSumByIndex += Math.pow(-1, i + 1) * Math.pow(i, 2);
        }

        System.out.printf("Sum of the series = %d%n", seriesSumByIndex);
    }
}
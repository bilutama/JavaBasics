package Lect_09;

import java.util.Scanner;

public class MultiplicationTableInArray {
    public static void main(String[] args) {
        System.out.println("*** Forms and prints multiplication table using an array ***");

        Scanner scanner = new Scanner(System.in);

        int rowsCount = 0;

        while (rowsCount < 1) {
            System.out.print("Rows count (> 0): ");
            rowsCount = scanner.nextInt();
        }

        int columnsCount = 0;

        while (columnsCount < 1) {
            System.out.print("Columns count (> 0): ");
            columnsCount = scanner.nextInt();
        }

        int[][] multiplicationTable = getMultiplicationTable(rowsCount, columnsCount);
        printMultiplicationTable(multiplicationTable);
    }

    public static int[][] getMultiplicationTable(int rowsCount, int columnsCount) {
        int[][] multiplicationTable = new int[rowsCount][columnsCount];

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }

        return multiplicationTable;
    }

    public static void printMultiplicationTable(int[][] multiplicationTable) {
        // printing the first line
        System.out.print("    ");

        for (int i = 1; i <= multiplicationTable[0].length; ++i) {
            System.out.printf("%4d", i);
        }

        System.out.println();

        // printing the separator
        for (int i = 0; i < multiplicationTable[0].length + 1; ++i) {
            System.out.print("____");
        }

        System.out.println();

        // printing the multiplication table
        for (int i = 0; i < multiplicationTable.length; ++i) {
            System.out.printf("%3d|", i + 1);

            for (int j = 0; j < multiplicationTable[0].length; ++j) {
                System.out.printf("%4d", multiplicationTable[i][j]);
            }

            System.out.println();
        }
    }
}
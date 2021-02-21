package JavaCourseTasks;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("*** Prints multiplication table ***");

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

        // printing the first line
        System.out.print("    ");
        
        for (int i = 1; i <= columnsCount; i++) {
            System.out.printf("%4d", i);
        }

        System.out.println();

        // printing the separator
        for (int i = 1; i <= columnsCount + 1; i++) {
            System.out.print("____");
        }

        System.out.println();

        // printing the multiplication table
        for (int i = 1; i <= rowsCount; i++) {
            System.out.printf("%3d|", i);
            
            for (int j = 1; j <= columnsCount; j++) {
                System.out.printf("%4d", i * j);
            }

            System.out.println();
        }
    }
}
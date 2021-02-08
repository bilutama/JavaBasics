package JavaCourseTasks;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("*** Prints multiplication table ***");

        Scanner scanner = new Scanner(System.in);

        int rowCount = 0;

        while (rowCount < 2) {
            System.out.print("Row count (> 1): ");
            rowCount = scanner.nextInt();
        }

        int columnCount = 0;

        while (columnCount < 2) {
            System.out.print("Column count (> 1): ");
            columnCount = scanner.nextInt();
        }

        // printing the first line
        for (int i = 1; i <= columnCount; i++) {
            if (i > 1) {
                System.out.printf("%4d", i);
            } else {
                System.out.print("    ");
            }
        }

        System.out.println();

        // printing the separator
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("____");
        }

        System.out.println();

        // printing the multiplication table
        for (int i = 2; i <= rowCount; i++) {
            for (int j = 1; j <= columnCount; j++) {
                if (j == 1) {
                    System.out.printf("%3d|", i);
                } else {
                    System.out.printf("%4d", i * j);
                }
            }

            System.out.println();
        }
    }
}

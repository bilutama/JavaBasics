package JavaCourseTasks;

import java.util.Scanner;

public class FibonacciMatrix {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Returns Fibonacci number by index ***");

        int fibonacciNumberIndex = 0;

        while (fibonacciNumberIndex < 1 || fibonacciNumberIndex > 92) {
            System.out.print("Enter an index (> 0 and < 93): ");
            fibonacciNumberIndex = scanner.nextInt();
        }

        long algorithmStartTime = System.currentTimeMillis();

        long[][] basicMatrix = {
                {1L, 1L},
                {1L, 0L}
        };

        try {
            long[][] fibonacciMatrix = getMatrixInPower(basicMatrix, fibonacciNumberIndex - 1);
            System.out.printf("Number #%d = %,d%n", fibonacciNumberIndex, fibonacciMatrix[0][0]);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        long algorithmEndTime = System.currentTimeMillis();
        System.out.printf("< Executed in %dms >%n", algorithmEndTime - algorithmStartTime);
    }

    public static long[][] getMatricesProduct(long[][] matrix1, long[][] matrix2) throws Exception {
        if (matrix1[0].length != matrix2.length) {
            throw new Exception("ERROR: multiplication of matrices is impossible");
        }

        long[][] matrixProduct = new long[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    matrixProduct[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return matrixProduct;
    }

    public static long[][] getMatrixInPower(long[][] matrix, int n) throws Exception {
        if (matrix.length != matrix[0].length) {
            throw new Exception("ERROR: impossible to power the matrix");
        }

        long[][] matrixInPower;

        if (n == 0) {
            matrixInPower = new long[matrix.length][matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                matrixInPower[i][i] = 1;
            }
        } else {
            if (n % 2 == 0) {
                long[][] temporaryMatrix = getMatrixInPower(matrix, n / 2);
                matrixInPower = getMatricesProduct(temporaryMatrix, temporaryMatrix);
            } else {
                long[][] temporaryMatrix = getMatrixInPower(matrix, (n - 1) / 2);
                matrixInPower = getMatricesProduct(matrix, getMatricesProduct(temporaryMatrix, temporaryMatrix));
            }
        }

        return matrixInPower;
    }

    public static void printMatrix(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%,10d", matrix[i][j]);
            }

            System.out.println();
        }
    }
}

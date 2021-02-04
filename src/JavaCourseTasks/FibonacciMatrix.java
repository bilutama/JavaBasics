package JavaCourseTasks;

import java.util.Scanner;

public class FibonacciMatrix {
    public static void main(String[] args) throws Exception {
        System.out.println("*** Returns Fibonacci number by index ***");

        Scanner scanner = new Scanner(System.in);

        int fibonacciNumberIndex = 0;
        while (fibonacciNumberIndex < 1 || fibonacciNumberIndex > 47) {
            System.out.print("Enter an index (> 0 and < 48): ");
            fibonacciNumberIndex = scanner.nextInt();
        }

        long algorithmStartTime = System.currentTimeMillis();

        int[][] basicMatrix = {
                {1, 1},
                {1, 0}
        };

        try {
            int[][] fibonacciMatrix = getMatrixInPower(basicMatrix, fibonacciNumberIndex);
            System.out.printf("Number #%d = %d%n", fibonacciNumberIndex, fibonacciMatrix[0][1]);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        long algorithmEndTime = System.currentTimeMillis();
        System.out.printf("< Executed in %dms >%n", algorithmEndTime - algorithmStartTime);
    }

    public static int[][] getMatricesMultiplication(int[][] matrix1, int[][] matrix2) throws Exception {
        if (matrix1[0].length != matrix2.length) {
            throw new Exception("ERROR: multiplication of matrices is impossible");
        }

        int[][] matrixProduct = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    matrixProduct[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixProduct;
    }

    public static int[][] getMatrixInPower(int[][] matrix, int n) throws Exception {
        if (matrix.length != matrix[0].length) {
            throw new Exception("ERROR: impossible to power the matrix");
        }

        int[][] matrixInPower;

        if (n == 0) {
            matrixInPower = new int[matrix.length][matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                matrixInPower[i][i] = 1;
            }
        } else {
            matrixInPower = matrix;

            for (int i = 1; i < n; ++i) {
                try {
                matrixInPower = getMatricesMultiplication(matrixInPower, matrix);
                }
                catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
        return matrixInPower;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%10d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
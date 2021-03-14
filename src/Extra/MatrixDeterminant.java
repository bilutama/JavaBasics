package Extra;

public class MatrixDeterminant {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 1},
                {1, 3, 1},
                {7, 8, 9}
        };

        System.out.println(getMatrixDeterminant(matrix));
        //printMatrix(getSubmatrix(matrix, 0, 1));
    }

    public static int getMatrixDeterminant(int[][] matrix) {
        int determinant = 0;

        // Определитель для элементарной матрицы
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        for (int i = 0; i < matrix.length; ++i) {
            determinant += (1 - 2 * (i % 2)) * matrix[i][0] * getMatrixDeterminant(getSubmatrix(matrix, i, 0));
            //determinant += matrix[i][0] * getMatrixDeterminant(getSubmatrix(matrix, i, 0));
        }
        //System.out.println(determinant);
        return determinant;
    }

    public static int[][] getSubmatrix(int[][] matrix, int excludedRowIndex, int excludedColumnIndex) {
        int[][] subMatrix = new int[matrix[0].length - 1][matrix[0].length - 1];

        int shiftIndexRow = 0;
        int shiftIndexColumn = 0;

        for (int i = 0; i < matrix.length; ++i) {
            // Пропуск строки и вычисление сдвига индекса по строке
            if (i == excludedRowIndex) {
                continue;
            }

            if (i > excludedRowIndex) {
                shiftIndexRow = -1;
            } else {
                shiftIndexRow = 0;
            }

            for (int j = 0; j < matrix[0].length; ++j) {

                // Пропуск столбца и вычисление сдвига индекса по столбцу
                if (j == excludedColumnIndex) {
                    continue;
                }

                if (j > excludedColumnIndex) {
                    shiftIndexColumn = -1;
                } else {
                    shiftIndexColumn = 0;
                }

                subMatrix[i + shiftIndexRow][j + shiftIndexColumn] = matrix[i][j];
            }
        }

        return subMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.printf("%4d", matrix[i][j]);
            }

            System.out.println();
        }
    }
}
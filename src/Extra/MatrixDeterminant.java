package Extra;

public class MatrixDeterminant {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, -2, 3},
                {4, 8, 6},
                {-7, 8, 9},
        };

        printMatrix(matrix);
        try {
            System.out.printf("Determinant = %d%n", getMatrixDeterminant(matrix));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int getMatrixDeterminant(int[][] matrix) throws Exception {
        if (matrix.length != matrix[0].length) {
            throw new Exception("The matrix is not square, could not get determinant.");
        }

        if (matrix.length == 1) {
            return matrix[0][0];
        }

        // Индекс столбца матрицы, по которой считается определитель
        final int REFERENCE_COLUMN_INDEX = 0;
        int determinant = 0;

        for (int i = 0; i < matrix.length; ++i) {
            determinant += (1 - 2 * (i % 2)) * matrix[i][REFERENCE_COLUMN_INDEX] * getMatrixDeterminant(getMinor(matrix, i, REFERENCE_COLUMN_INDEX));
        }

        return determinant;
    }

    // Вычисление минора основной матрицы
    public static int[][] getMinor(int[][] matrix, int excludedRowIndex, int excludedColumnIndex) {
        int[][] minor = new int[matrix[0].length - 1][matrix[0].length - 1];

        for (int i = 0; i < matrix.length; ++i) {
            // Пропуск референсной строки
            if (i == excludedRowIndex) {
                continue;
            }

            // Вычисление сдвига индекса по строке
            int rowIndexShift = i > excludedRowIndex ? -1 : 0;

            for (int j = 0; j < matrix[0].length; ++j) {
                // Пропуск референсного столбца
                if (j == excludedColumnIndex) {
                    continue;
                }

                // Вычисление сдвига индекса по столбцу
                int columnIndexShift = j > excludedColumnIndex ? -1 : 0;
                minor[i + rowIndexShift][j + columnIndexShift] = matrix[i][j];
            }
        }

        return minor;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Matrix:");

        for (int[] element : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.printf("%3d", element[j]);
            }

            System.out.println();
        }
    }
}
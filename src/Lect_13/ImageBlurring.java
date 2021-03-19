package Lect_13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageBlurring {
    public static void main(String[] args) throws IOException {
        // читаем картинку из файлу image.jpg в объект класса BufferedImage
        BufferedImage inputImage = ImageIO.read(new File("image.jpg"));

        // получаем растр - объект, внутри которого содержится двумерный массив пикселей
        WritableRaster inputRaster = inputImage.getRaster();

        // получаем ширину и высоту картинки
        int width = inputRaster.getWidth();
        int height = inputRaster.getHeight();

        // Создаем новое изображение и растр, в который будем записывать результат,
        // той же размерности, что и исходное изображение
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster outputRaster = outputImage.getRaster();

        final int COLORS_COUNT_IN_RGB = 3;
        final int MIN_RGB = 0;
        final int MAX_RGB = 255;

        // Степень размытия - значение, от которой вычисляется размерность матрицы размытия
        final int BLURRING_STRENGTH = 3;

        // Размерность матрицы размытия
        int convolutionMatrixDimension = BLURRING_STRENGTH * 2 + 1;

        double[][] convolutionMatrix = new double[convolutionMatrixDimension][convolutionMatrixDimension];

        // Инициализация матрицы размытия
        double normalizedConvolutionMatrixElement = 1.0 / (convolutionMatrixDimension * convolutionMatrixDimension);

        for (int i = 0; i < convolutionMatrixDimension; ++i) {
            for (int j = 0; j < convolutionMatrixDimension; ++j) {
                convolutionMatrix[i][j] = normalizedConvolutionMatrixElement;
            }
        }

        // начальный, конечный и вспомогательный (для промежуточных вычислений) пиксели
        int[] inputPixel = new int[COLORS_COUNT_IN_RGB];
        int[] outputPixel = new int[COLORS_COUNT_IN_RGB];
        double[] intermediateOutputPixel = new double[COLORS_COUNT_IN_RGB];

        int indent = convolutionMatrixDimension / 2;
        int widthIndent = width - indent;
        int heightIndent = height - indent;

        // цикл по столбцу картинки
        for (int x = 0; x < width; ++x) {
            // цикл по строке картинки
            for (int y = 0; y < height; ++y) {
                // Проверка на граничные пиксели - их не меняем, т.к. матрица размытия выйдет за пределы изображения
                if (x <= indent || x >= widthIndent ||
                        y <= indent || y >= heightIndent) {
                    inputRaster.getPixel(x, y, outputPixel);
                    outputRaster.setPixel(x, y, outputPixel);
                    continue;
                }

                int processedImageAreaLeftTopX = x - indent;
                int processedImageAreaLeftTopY = y - indent;

                // цикл по матрице свертки
                for (int i = 0; i < convolutionMatrixDimension; ++i) {
                    for (int j = 0; j < convolutionMatrixDimension; ++j) {
                        inputRaster.getPixel(processedImageAreaLeftTopX + j, processedImageAreaLeftTopY + i, inputPixel);

                        for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                            intermediateOutputPixel[k] += inputPixel[k] * convolutionMatrix[i][j];
                        }
                    }
                }

                // покомпонентная запись вычисленных цветов в результирующий пиксель
                // с проверкой выхода значений за пределы RGB[0..255]
                for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                    outputPixel[k] = (int) intermediateOutputPixel[k];

                    if (outputPixel[k] > MAX_RGB) {
                        outputPixel[k] = MAX_RGB;
                        continue;
                    }

                    if (outputPixel[k] < MIN_RGB) {
                        outputPixel[k] = MIN_RGB;
                    }
                }

                // Очистка вспомогательного пикселя
                for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                    intermediateOutputPixel[k] = 0.0;
                }

                // записываем пиксель в картинку
                outputRaster.setPixel(x, y, outputPixel);
            }
        }

        // сохраняем картинку в файл
        String fileName = "out_blurred_strength=" + BLURRING_STRENGTH + ".jpg";
        ImageIO.write(outputImage, "jpg", new File(fileName));
    }
}
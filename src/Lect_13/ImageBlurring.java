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

        // Степень размытия и отступ от краев изображения
        final int INDENT = 3;

        // Размерность матрицы размытия
        int convolutionMatrixDimension = INDENT * 2 + 1;

        double[][] convolutionMatrix = new double[convolutionMatrixDimension][convolutionMatrixDimension];

        // Инициализация матрицы размытия
        double normalizedConvolutionMatrixElement = 1.0 / (convolutionMatrixDimension * convolutionMatrixDimension);

        for (int i = 0; i < convolutionMatrixDimension; ++i) {
            for (int j = 0; j < convolutionMatrixDimension; ++j) {
                convolutionMatrix[i][j] = normalizedConvolutionMatrixElement;
            }
        }

        // начальный, конечный и вспомогательный (для промежуточных вычислений) пиксели
        int[] pixel = new int[COLORS_COUNT_IN_RGB];
        double[] intermediatePixel = new double[COLORS_COUNT_IN_RGB];

        int widthIndent = width - INDENT;
        int heightIndent = height - INDENT;

        // цикл по столбцу картинки
        for (int x = 0; x < width; ++x) {
            // цикл по строке картинки
            for (int y = 0; y < height; ++y) {
                // Проверка на граничные пиксели - их не меняем, т.к. матрица размытия выйдет за пределы изображения
                if (x < INDENT || x >= widthIndent ||
                        y < INDENT || y >= heightIndent) {
                    inputRaster.getPixel(x, y, pixel);
                    outputRaster.setPixel(x, y, pixel);
                    continue;
                }

                int processedImageAreaLeftTopX = x - INDENT;
                int processedImageAreaLeftTopY = y - INDENT;

                // цикл по матрице свертки
                for (int i = 0; i < convolutionMatrixDimension; ++i) {
                    for (int j = 0; j < convolutionMatrixDimension; ++j) {
                        inputRaster.getPixel(processedImageAreaLeftTopX + j, processedImageAreaLeftTopY + i, pixel);

                        for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                            intermediatePixel[k] += pixel[k] * convolutionMatrix[i][j];
                        }
                    }
                }

                // покомпонентная запись вычисленных цветов в результирующий пиксель
                // с проверкой выхода значений за пределы RGB[0..255]
                // и очистка вспомогательного пикселя
                for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                    pixel[k] = (int) intermediatePixel[k];
                    intermediatePixel[k] = 0.0;

                    if (pixel[k] > MAX_RGB) {
                        pixel[k] = MAX_RGB;
                        continue;
                    }

                    if (pixel[k] < MIN_RGB) {
                        pixel[k] = MIN_RGB;
                    }
                }

                // записываем пиксель в картинку
                outputRaster.setPixel(x, y, pixel);
            }
        }

        // сохраняем картинку в файл
        String fileName = "out_blurred_strength=" + INDENT + ".jpg";
        ImageIO.write(outputImage, "jpg", new File(fileName));
    }
}
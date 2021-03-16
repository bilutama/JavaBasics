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
        int blurringMatrixDimension = BLURRING_STRENGTH * 2 + 1;

        double[][] blurringMatrix = new double[blurringMatrixDimension][blurringMatrixDimension];

        // Инициализация матрицы размытия
        int normalizationFactor = blurringMatrixDimension * blurringMatrixDimension;

        for (int i = 0; i < blurringMatrixDimension; ++i) {
            for (int j = 0; j < blurringMatrixDimension; ++j) {
                blurringMatrix[i][j] = 1.0 / (normalizationFactor);
            }
        }

        // создаем массив, в котором будет содержаться текущий пиксель
        // это массив из 3 элементов, в нем по очереди лежат числа R, G, B
        // т.е. по индексу 0 будет лежать красная компонента, по индексу 1 - зеленая, по индексу 2 - синяя
        int[] inputPixel = new int[COLORS_COUNT_IN_RGB];
        int[] outputPixel = new int[COLORS_COUNT_IN_RGB];

        // цикл по строке картинки
        for (int x = 0; x < width; ++x) {
            // цикл по столбцу картинки
            for (int y = 0; y < height; ++y) {
                // Проверка на граничные пиксели - их не меняем, т.к. матрица размытия выйдет за пределы изображения
                if (x <= blurringMatrixDimension / 2 || x >= width - blurringMatrixDimension / 2 ||
                        y <= blurringMatrixDimension / 2 || y >= height - blurringMatrixDimension / 2) {
                    inputRaster.getPixel(x, y, outputPixel);
                    outputRaster.setPixel(x, y, outputPixel);
                    continue;
                }

                double[] intermediateOutputPixel = new double[COLORS_COUNT_IN_RGB];
                int processedImageAreaLeftTopX = x - blurringMatrixDimension / 2;
                int processedImageAreaLeftTopY = y - blurringMatrixDimension / 2;

                // цикл по матрице размытия
                for (int i = 0; i < blurringMatrixDimension; ++i) {
                    for (int j = 0; j < blurringMatrixDimension; ++j) {
                        inputRaster.getPixel(processedImageAreaLeftTopX + i, processedImageAreaLeftTopY + j, inputPixel);

                        // цикл по цвету
                        for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                            intermediateOutputPixel[k] += inputPixel[k] * blurringMatrix[i][j];
                        }
                    }
                }

                // покомпонентная запись вычисленных усредненных цветов в результирующий пиксель
                // с проверкой выхода значений за пределы 0..255
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

                // записываем пиксель в картинку
                outputRaster.setPixel(x, y, outputPixel);
            }
        }

        // сохраняем картинку в файл
        String fileName = "out_blurred_strength=" + BLURRING_STRENGTH + ".jpg";
        ImageIO.write(outputImage, "jpg", new File(fileName));
    }
}
package Lect_13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageBlurring {
    public static void main(String[] args) throws IOException {
        // читаем картинку из файлу image.jpg в объект класса BufferedImage
        BufferedImage imageInput = ImageIO.read(new File("image.jpg"));

        // получаем растр - объект, внутри которого содержится двумерный массив пикселей
        WritableRaster rasterInput = imageInput.getRaster();

        // получаем ширину и высоту картинки
        int width = rasterInput.getWidth();
        int height = rasterInput.getHeight();

        // Создаем новое изображение и растр, в который будем записывать результат,
        // той же размерности, что и исходное изображение
        BufferedImage imageOutput = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster rasterOutput = imageOutput.getRaster();

        final int COLORS_COUNT_IN_RGB = 3;
        //final int MAX_RGB = 255;

        // Степень размытия - значение, от которой вычисляется размерность матрицы размытия
        final int BLURRING_STRENGTH = 3;

        // Размерность матрицы размытия
        int blurringMatrixDimension = BLURRING_STRENGTH * 2 + 1;
        
        double[][] blurringMatrix = new double[blurringMatrixDimension][blurringMatrixDimension];

        // Инициализация матрицы размытия
        for (int i = 0; i < blurringMatrixDimension; ++i) {
            for (int j = 0; j < blurringMatrixDimension; ++j) {
                blurringMatrix[i][j] = 1.0 / (blurringMatrixDimension * blurringMatrixDimension);
            }
        }

        // создаем массив, в котором будет содержаться текущий пиксель
        // это массив из 3 элементов, в нем по очереди лежат числа R, G, B
        // т.е. по индексу 0 будет лежать красная компонента, по индексу 1 - зеленая, по индексу 2 - синяя
        int[] pixel = new int[COLORS_COUNT_IN_RGB];
        int[] tempPixel = new int[COLORS_COUNT_IN_RGB];

        // цикл по строкам картинки
        for (int y = 0; y < height; ++y) {
            // цикл пикселям строки
            for (int x = 0; x < width; ++x) {
                for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                    // Проверка на граничные пиксели - их не меняем, т.к. матрица размытия выйдет за пределы изображения
                    if (y < blurringMatrixDimension / 2 + 1 || y >= height - blurringMatrixDimension / 2 ||
                            x < blurringMatrixDimension / 2 + 1 || x >= width - blurringMatrixDimension / 2) {
                        rasterInput.getPixel(x, y, tempPixel);
                        pixel[k] = tempPixel[k];
                    } else {
                        double blurredPixel = 0.0;

                        // циклы по матрице размытия
                        for (int i = 0; i < blurringMatrixDimension; ++i) {
                            for (int j = 0; j < blurringMatrixDimension; ++j) {
                                // получаем пиксели по матрице вокруг текущего с координатами (x, y)
                                rasterInput.getPixel(x + i - blurringMatrixDimension / 2, y + j - blurringMatrixDimension / 2, tempPixel);
                                // и суммируем с перемножением на коэффициенты матрицы размытия
                                blurredPixel += tempPixel[k] * blurringMatrix[i][j];
                            }
                        }

                        pixel[k] = (int) blurredPixel;
                    }
                }

                // записываем значения цветов для пикселя в картинку
                rasterOutput.setPixel(x, y, pixel);
            }
        }

        // сохраняем картинку в файл
        String fileName = "out_blurred_strength=" + BLURRING_STRENGTH + ".jpg";
        ImageIO.write(imageOutput, "jpg", new File(fileName));
    }
}

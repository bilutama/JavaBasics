package Lect_13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageBlurring {
    public static void main(String[] args) throws IOException {
        // читаем картинку из файлу image.jpg в объект класса BufferedImage
        BufferedImage image = ImageIO.read(new File("image.jpg"));

        // получаем растр - объект, внутри которого содержится двумерный массив пикселей
        WritableRaster raster = image.getRaster();

        // получаем ширину и высоту картинки
        int width = raster.getWidth();
        int height = raster.getHeight();

        // Создаем новое изображение и растр, в который будем записывать результат,
        // той же размерности, что и исходное изображение
        BufferedImage imageOutput = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster rasterOutput = imageOutput.getRaster();

        final int COLORS_COUNT_IN_RGB = 3;
        //final int MAX_RGB = 255;

        // Сила размытия, т.е. размерность матрицы пикселей, участвующих в усреднении
        // например, 3, 5, 7
        final int BLURRING_STRENGTH = 7;
        double[][] blurringMatrix = new double[BLURRING_STRENGTH][BLURRING_STRENGTH];

        // Инициализация матрицы размытия
        for (int i = 0; i < BLURRING_STRENGTH; ++i) {
            for (int j = 0; j < BLURRING_STRENGTH; ++j) {
                blurringMatrix[i][j] = 1.0 / (BLURRING_STRENGTH * BLURRING_STRENGTH);
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
                    if (y < BLURRING_STRENGTH / 2 + 1 || y >= height - BLURRING_STRENGTH / 2 ||
                            x < BLURRING_STRENGTH / 2 + 1 || x >= width - BLURRING_STRENGTH / 2) {
                        raster.getPixel(x, y, tempPixel);
                        pixel[k] = tempPixel[k];
                    } else {
                        double blurredPixel = 0.0;

                        // циклы по матрице размытия
                        for (int i = 0; i < BLURRING_STRENGTH; ++i) {
                            for (int j = 0; j < BLURRING_STRENGTH; ++j) {
                                // получаем пиксели по матрице вокруг текущего с координатами (x, y)
                                raster.getPixel(x + i - BLURRING_STRENGTH / 2, y + j - BLURRING_STRENGTH / 2, tempPixel);
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
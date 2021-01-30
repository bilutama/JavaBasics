package Lect_01_02;

public class Calculations {
    public static void main(String[] args) {
        double x = 3 - (56.0 - 12) / 44 * 4 / 2;
        System.out.println("x = 3 - (56 - 8) / 44 * 4 / 2 = " + x);

        double y = 2.0 * x / (33 - x);
        System.out.println("y = 2 * x / (33 - x) = " + y);

        double z = -x / (2 * y);
        System.out.println("z = - x / (2 * y) = " + z);
    }
}
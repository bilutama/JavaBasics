package Lect_06;

public class OverloadedFunction {
    public static void main(String[] args) {
        byte byteVariable = 1;
        short shortVariable = 1;
        int intVariable = 1;
        long longVariable = 1L;
        float floatVariable = 1.0f;
        double doubleVariable = 1.0;

        System.out.printf("Byte type size, bytes: %d%n", getTypeSize(byteVariable));
        System.out.printf("Short type size, bytes: %d%n", getTypeSize(shortVariable));
        System.out.printf("Int type size, bytes: %d%n", getTypeSize(intVariable));
        System.out.printf("Long type size, bytes: %d%n", getTypeSize(longVariable));
        System.out.printf("Float type size, bytes: %d%n", getTypeSize(floatVariable));
        System.out.printf("Double type size, bytes: %d%n", getTypeSize(doubleVariable));
    }

    public static int getTypeSize(byte variable) {
        return 1;
    }

    public static int getTypeSize(short variable) {
        return 2;
    }

    public static int getTypeSize(int variable) {
        return 4;
    }

    public static int getTypeSize(long variable) {
        return 8;
    }

    public static int getTypeSize(float variable) {
        return 4;
    }

    public static int getTypeSize(double variable) {
        return 8;
    }
}
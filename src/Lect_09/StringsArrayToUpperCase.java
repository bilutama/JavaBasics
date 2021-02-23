package Lect_09;

public class StringsArrayToUpperCase {
    public static void main(String[] args) {
        String[] array = {"the", "Show", "MUST", "gO", "on", null};

        printArray(array);

        convertToUpperCase(array);
        printArray(array);
    }

    public static void convertToUpperCase(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != null) {
                array[i] = array[i].toUpperCase();
            }
        }
    }

    public static void printArray(String[] array) {
        for (String string : array) {
            if (string != null) {
                System.out.printf("%s ", string);
            } else {
                System.out.print("[null] ");
            }
        }

        System.out.println();
    }
}
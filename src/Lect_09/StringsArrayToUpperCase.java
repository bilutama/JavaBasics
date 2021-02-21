package Lect_09;

public class StringsArrayToUpperCase {
    public static void main(String[] args) {
        String[] array = new String[]{"the", "Show", "MUST", "gO", "on", null};

        printArray(array);

        applyUpperCase(array);
        printArray(array);
    }

    public static void applyUpperCase(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != null) {
                array[i] = array[i].toUpperCase();
            }
        }
    }

    public static void printArray(String[] array) {
        for (String word : array) {
            if (word != null) {
                System.out.printf("%s ", word);
            } else {
                System.out.print("[null] ");
            }
        }

        System.out.println();
    }
}
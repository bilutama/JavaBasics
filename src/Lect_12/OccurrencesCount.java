package Lect_12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class OccurrencesCount {
    public static void main(String[] args) {
        System.out.println("*** Counts occurrences of a string in a file (not case sensitive) ***");

        String inputFileName = "input.txt";
        String string = "text";
        System.out.printf("%d occurrences found", getStringOccurrencesCount(inputFileName, string));
    }

    public static int getStringOccurrencesCount(String inputFileName, String string) {
        int stringCount = 0;

        try (Scanner scanner = new Scanner(new FileInputStream(inputFileName))) {
            String stringToLowerCase = string.toLowerCase();

            while (scanner.hasNextLine()) {
                int currentIndex = 0;
                int counterInLine = 0;
                String line = scanner.nextLine().toLowerCase();

                while (true) {
                    currentIndex = line.indexOf(stringToLowerCase, currentIndex);

                    if (currentIndex == -1) {
                        stringCount += counterInLine;
                        break;
                    }

                    currentIndex += string.length();
                    ++counterInLine;
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return stringCount;
    }
}
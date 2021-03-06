package Lect_12;

import java.io.*;
import java.util.Scanner;

public class TextInFileToUpperCase {
    public static void main(String[] args) {
        System.out.println("*** Converts text in a file to upper case ***");

        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        convertTextInFileToUpperCase(inputFileName, outputFileName);
    }

    public static void convertTextInFileToUpperCase(String inputFileName, String outputFileName) {
        try (Scanner scanner = new Scanner(new FileInputStream(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            while (scanner.hasNextLine()) {
                writer.println(scanner.nextLine().toUpperCase());
            }

            System.out.printf("Success! Result is in the file \"%s\"%n", outputFileName);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
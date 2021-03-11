package Lect_12;

import java.io.*;
import java.util.Scanner;

public class ConvertFileContentToUpperCase {
    public static void main(String[] args) {
        System.out.println("*** Converts text from a file to upper case ***");

        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        stringFromFileToUpperCase(inputFileName, outputFileName);
    }

    public static void stringFromFileToUpperCase(String inputFileName, String outputFileName) {
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
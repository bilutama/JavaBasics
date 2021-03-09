package Lect_12;

import java.io.*;
import java.util.Scanner;

public class FileInUpperCase {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("*** Converts strings to upper case ***");

        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        stringFromFileToUpperCase(inputFile, outputFile);
    }

    public static void stringFromFileToUpperCase (String inputFile, String outputFile) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
            PrintWriter writer = new PrintWriter(outputFile)) {
                while (scanner.hasNextLine()) {
                    writer.println(scanner.nextLine().toUpperCase());
                }

                System.out.println("Success!");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

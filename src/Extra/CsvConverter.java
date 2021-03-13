package Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvConverter {
    public static void main(String[] args) {
        System.out.println("*** Converts csv to html ***");

        String inputFileName = "inputCsv.txt";
        String outputFileName = "outputCsv.txt";
        convertTextInFileToUpperCase(inputFileName, outputFileName);
    }

    public static void convertTextInFileToUpperCase(String inputFileName, String outputFileName) {
        try (Scanner scanner = new Scanner(new FileInputStream(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            //String separator = ",";
            //String beginQuotes = "\"";
            StringBuilder stringBuilder = new StringBuilder();

            while (scanner.hasNextLine()) {

                stringBuilder.append(scanner.nextLine()).append("\n");
            }

            writer.println(stringBuilder.toString().trim());
            //System.out.println(stringBuilder.toString());

            System.out.printf("Success! Result is in the file \"%s\"%n", outputFileName);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
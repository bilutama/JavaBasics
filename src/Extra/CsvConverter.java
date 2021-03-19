package Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvConverter {
    public static void main(String[] args) {
        System.out.println("*** Converts csv to html ***");

        String str = "\"\"\"\" & <>";
        System.out.println(str);
        System.out.println(formatCellToHtml(str));
//        String inputFileName = "inputCsv.txt";
//        String outputFileName = "outputCsv.txt";
//        convertCsvToHtmlTable(inputFileName, outputFileName);
    }

    public static void convertCsvToHtmlTable(String inputFileName, String outputFileName) {
        try (Scanner scanner = new Scanner(new FileInputStream(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            final char SEPARATOR = ',';
            final String BEGIN_QUOTES = "\"";

            boolean isQuotesOpen = false;
            //boolean isRowFinished = true;

            StringBuilder stringBuilder = new StringBuilder();

            String processedString;

            while (scanner.hasNextLine()) {
                processedString = scanner.nextLine();

                for (int i = 0; i < processedString.length(); ++i) {
                    if (processedString.charAt(i) != SEPARATOR) {

                    }
                }
            }

            writer.println(stringBuilder.toString().trim());
            //System.out.println(stringBuilder.toString());

            System.out.printf("Success! Result is in the file \"%s\"%n", outputFileName);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String formatCellToHtml(String string) {
        final String[][] CHAR_REPLACEMENTS = {
                {"\"\"", "\""},
                {"&", "&amp"},
                {"<", "&lt"},
                {">", "&gt"},
                {"\n", "<br/>"}
        };

        String resultString = string;

        for (String[] char_replacement : CHAR_REPLACEMENTS) {
            resultString = resultString.replace(char_replacement[0], char_replacement[1]);
        }

        return resultString;
    }

    public static String getWrappedFormattedCell (String cellString) {
        return "<td>" + formatCellToHtml(cellString) + "</td>";
    }

    public static String getWrappedTableRow (String tableRow) {
        return "<tr>" + tableRow + "</tr>";
    }
}
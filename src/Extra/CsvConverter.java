package Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CsvConverter {
    public static void main(String[] args) {
        System.out.println("*** Converts csv to html ***");

        String inputFileName = "inputCsv.txt";
        String outputFileName = "outputCsv.html";

        convertCsvToHtmlTable(inputFileName, outputFileName);
    }

    public static void convertCsvToHtmlTable(String inputFileName, String outputFileName) {
        try (Scanner scanner = new Scanner(new FileInputStream(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.println("<table>");

            final char SEPARATOR = ',';
            final char QUOTES = '\"';
            final char EOL = '\n';

            StringBuilder newCell = new StringBuilder();
            String processedString;

            boolean separatorMode = true;
            boolean isNewCell = true;

            while (scanner.hasNextLine()) {
                processedString = scanner.nextLine();

                int beginIndex = 0;
                int endIndex;

                int i = 0;

                while (i < processedString.length()) {
                    char currentChar = processedString.charAt(i);
                    char nextChar = (i < processedString.length() - 1) ? processedString.charAt(i + 1) : '\n';

                    if (i == 0 && isNewCell) {
                        newCell.append("<tr>");
                    }

                    // Обработка начала новой ячейки
                    if (isNewCell) {
                        newCell.append("<td>");

                        if (currentChar == SEPARATOR) {
                            if (nextChar == SEPARATOR || nextChar == EOL) {
                                newCell.append("</td>");
                            }

                            ++i;
                            continue;
                        }

                        isNewCell = false;

                        if (currentChar == QUOTES) {
                            beginIndex = i + 1;
                            separatorMode = false;
                        } else {
                            beginIndex = i;
                        }

                        continue;
                    }

                    if (separatorMode) {
                        if (nextChar == SEPARATOR) {
                            endIndex = i + 1;

                            newCell.append(processedString, beginIndex, endIndex).append("</td>");

                            isNewCell = true;
                            i = i + 2;
                            continue;
                        }

                        if (nextChar == EOL) {
                            endIndex = i + 1;

                            newCell.append(processedString, beginIndex, endIndex).append("</td>").append("</tr>");

                            writer.println(newCell.toString());
                            newCell = new StringBuilder();

                            isNewCell = true;
                            ++i;
                            continue;
                        }

                        ++i;
                        continue;
                    }

                    if (currentChar == QUOTES) {
                        if (nextChar == QUOTES) {
                            i = i + 2;
                            continue;
                        }

                        if (nextChar == SEPARATOR) {
                            endIndex = i;
                            newCell.append(processedString, beginIndex, endIndex).append("</td>");

                            separatorMode = true;
                            isNewCell = true;
                            i = i + 2;
                            continue;
                        }

                        // Ковычки - последний символ в строке
                        if (nextChar == EOL) {
                            endIndex = i;
                            newCell.append(processedString, beginIndex, endIndex).append("</td>").append("</tr>");

                            writer.println(newCell.toString());
                            newCell = new StringBuilder();

                            separatorMode = true;
                            isNewCell = true;
                            ++i;
                            continue;
                        }
                    }

                    if (nextChar == EOL) {
                        endIndex = i + 1;
                        newCell.append(processedString, beginIndex, endIndex).append("<br/>");

                        ++i;
                        continue;
                    }

                    ++i;
                }
            }

            writer.println("</table>");

            System.out.printf("Success! Result is in the file \"%s\"%n", outputFileName);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String replaceChars(String inputString) {
        final String[][] REPLACEMENTS = {
                {"\"\"", "\""},
                {"&", "&amp"},
                {"<", "&lt"},
                {">", "&gt"}
        };

        String resultString = "";

        for (String[] row : REPLACEMENTS) {
            resultString = inputString.replace(row[0], row[1]);
        }

        return resultString;
    }
}
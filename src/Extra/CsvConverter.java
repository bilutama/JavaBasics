package Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Scanner;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
            final char SEPARATOR = ',';
            final char QUOTES = '\"';
            final char EOL = '\n';
                    
            final String TABLE_OPEN_TAG = "<table>";
            final String TABLE_CLOSE_TAG = "</table>";
            final String ROW_OPEN_TAG = "<tr>";
            final String ROW_CLOSE_TAG = "</tr>";
            final String CELL_OPEN_TAG = "<td>";
            final String CELL_CLOSE_TAG = "</td>";
            final String BREAK_LINE_TAG = "<br/>";

            writer.println(TABLE_OPEN_TAG);

            StringBuilder newCell = new StringBuilder();
            String processedString;

            boolean separatorMode = true;
            boolean isNewCell = true;

            while (scanner.hasNextLine()) {
                processedString = replaceChars(scanner.nextLine());

                int beginIndex = 0;
                int endIndex;

                int i = 0;

                while (i < processedString.length()) {
                    char currentChar = processedString.charAt(i);
                    char nextChar = (i < processedString.length() - 1) ? processedString.charAt(i + 1) : EOL;

                    if (i == 0 && isNewCell) {
                        newCell.append(ROW_OPEN_TAG).append(EOL);
                    }

                    // Обработка начала новой ячейки
                    if (isNewCell) {
                        newCell.append(CELL_OPEN_TAG);

                        if (currentChar == SEPARATOR) {
                            if (nextChar == SEPARATOR || nextChar == EOL) {
                                newCell.append(CELL_CLOSE_TAG).append(EOL);
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

                            newCell.append(processedString, beginIndex, endIndex).append(CELL_CLOSE_TAG).append(EOL);

                            isNewCell = true;
                            i = i + 2;
                            continue;
                        }

                        if (nextChar == EOL) {
                            endIndex = i + 1;

                            newCell.append(processedString, beginIndex, endIndex).append(CELL_CLOSE_TAG).append(EOL).append(ROW_CLOSE_TAG);

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
                        if (nextChar == SEPARATOR) {
                            endIndex = i;
                            newCell.append(processedString, beginIndex, endIndex).append(ROW_CLOSE_TAG).append(EOL);

                            separatorMode = true;
                            isNewCell = true;
                            i = i + 2;
                            continue;
                        }

                        // Ковычки - последний символ в строке
                        if (nextChar == EOL) {
                            endIndex = i;
                            newCell.append(processedString, beginIndex, endIndex).append(CELL_CLOSE_TAG).append(EOL).append(ROW_CLOSE_TAG);

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
                        newCell.append(processedString, beginIndex, endIndex).append(BREAK_LINE_TAG);

                        ++i;
                        continue;
                    }

                    ++i;
                }
            }

            writer.println(TABLE_CLOSE_TAG);

            System.out.printf("Success! Result is in the file \"%s\"%n", outputFileName);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String replaceChars(String inputString) {
        Pattern pattern = Pattern.compile("(\"\"|&|<|>)");
        Matcher matcher = pattern.matcher(inputString);
        
        Map<String, String> replacementMap = new HashMap<>();
        replacementMap.put("\"\"", "\"");
        replacementMap.put("&", "&amp");
        replacementMap.put("<", "&lt");
        replacementMap.put(">", "&gt");
        
        StringBuffer stringBuffer = new StringBuffer();
        
        while(matcher.find()) {
            String wordToReplace = matcher.group();
            matcher.appendReplacement(stringBuffer, replacementMap.get(wordToReplace));
        }
        
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}

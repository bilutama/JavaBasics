package Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
            final char END_OF_STRING = '\n';

            final String TABLE_OPEN_TAG = "<table>";
            final String TABLE_CLOSE_TAG = "</table>";
            final String ROW_OPEN_TAG = "<tr>";
            final String ROW_CLOSE_TAG = "</tr>";
            final String CELL_OPEN_TAG = "<td>";
            final String CELL_CLOSE_TAG = "</td>";
            final String BREAK_LINE_TAG = "<br/>";

            writer.println(TABLE_OPEN_TAG);

            StringBuilder stringBuilder = new StringBuilder();
            String processedString;

            boolean separatorMode = true;
            boolean isNewCell = true;

            while (scanner.hasNextLine()) {
                processedString = getFormattedString(scanner.nextLine());

                int beginIndex = 0;
                int endIndex;

                int i = 0;

                while (i < processedString.length()) {
                    char currentChar = processedString.charAt(i);
                    char nextChar = (i < processedString.length() - 1) ? processedString.charAt(i + 1) : END_OF_STRING;

                    if (i == 0 && isNewCell) {
                        stringBuilder.append(ROW_OPEN_TAG).append(END_OF_STRING);
                    }

                    // Обработка начала новой ячейки по флагу
                    if (isNewCell) {
                        stringBuilder.append(CELL_OPEN_TAG);

                        // Проверка и финализация ячейки, если она пустая
                        if (currentChar == SEPARATOR) {
                            if (nextChar == SEPARATOR || nextChar == END_OF_STRING) {
                                stringBuilder.append(CELL_CLOSE_TAG).append(END_OF_STRING);
                            }

                            ++i;
                            continue;
                        }

                        isNewCell = false;

                        // Определение индекса первого символа текста ячейки
                        // Если встречаем кавычки, то меняем режим чтения
                        if (currentChar == QUOTES) {
                            beginIndex = i + 1;
                            separatorMode = false;
                        } else {
                            beginIndex = i;
                        }

                        continue;
                    }

                    // Блок кода для режима чтения separatorMode, т.е. нет кавычек, читаем строку
                    // и проверяем следующий символ пока не встретим конец или разделитель
                    if (separatorMode) {
                        // Если вс разделитель, финализируем ячейку и дописываем в stringBuilder
                        if (nextChar == SEPARATOR) {
                            endIndex = i + 1;

                            stringBuilder.append(processedString, beginIndex, endIndex).append(CELL_CLOSE_TAG).append(END_OF_STRING);

                            isNewCell = true;
                            i = i + 2;
                            continue;
                        }

                        // Если , финализируем ячейку и дописываем в stringBuilder
                        if (nextChar == END_OF_STRING) {
                            endIndex = i + 1;

                            stringBuilder.append(processedString, beginIndex, endIndex).append(CELL_CLOSE_TAG).append(END_OF_STRING).append(ROW_CLOSE_TAG);

                            writer.println(replaceEscapeQuotes(stringBuilder.toString()));
                            stringBuilder = new StringBuilder();

                            isNewCell = true;
                            ++i;
                            continue;
                        }

                        ++i;
                        continue;
                    }

                    // Блок кода для режима чтения !separatorMode, т.е. когда содержимое ячейки в кавычках
                    // Если встречаем двойные кавычки, то смотрим следующий символ nextChar
                    if (currentChar == QUOTES) {
                        // Если nextChar - разделитель, то финализируем ячейку и добавляем в stringBuilder
                        if (nextChar == QUOTES) {
                            i = i + 2;
                            continue;
                        }

                        // Если nextChar - разделитель, то финализируем ячейку и добавляем в stringBuilder
                        if (nextChar == SEPARATOR) {
                            endIndex = i;
                            stringBuilder.append(processedString, beginIndex, endIndex).append(ROW_CLOSE_TAG).append(END_OF_STRING);

                            separatorMode = true;
                            isNewCell = true;
                            i = i + 2;
                            continue;
                        }

                        // Если nextChar - конец строки, то финализируем ячейку и строку
                        // добавляем в stringBuilder и записываем в html-файл и сбрасываем stringBuilder
                        if (nextChar == END_OF_STRING) {
                            endIndex = i;
                            stringBuilder.append(processedString, beginIndex, endIndex).append(CELL_CLOSE_TAG).append(END_OF_STRING).append(ROW_CLOSE_TAG);

                            writer.println(replaceEscapeQuotes(stringBuilder.toString()));
                            stringBuilder = new StringBuilder();

                            separatorMode = true;
                            isNewCell = true;
                            ++i;
                            continue;
                        }
                    }

                    // Если nextChar - конец строки, то вставляем тэг переноса строки
                    // и добавляем в stringBuilder.
                    // Далее строка заканчивается и читается новая из файла.
                    if (nextChar == END_OF_STRING) {
                        endIndex = i + 1;
                        stringBuilder.append(processedString, beginIndex, endIndex).append(BREAK_LINE_TAG);

                        ++i;
                        continue;
                    }

                    // Если ни одно условие выше не выполняется, то переходим к следующему символу
                    ++i;
                }
            }

            writer.println(TABLE_CLOSE_TAG);

            System.out.printf("Success! Result is in the file \"%s\"%n", outputFileName);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String replaceEscapeQuotes(String inputString) {
        Pattern pattern = Pattern.compile("(\"\")");
        Matcher matcher = pattern.matcher(inputString);

        return matcher.replaceAll("\"");
    }

    public static String getFormattedString(String inputString) {
        Pattern pattern = Pattern.compile("[&<>]");
        Matcher matcher = pattern.matcher(inputString);

        Map<String, String> replacementMap = new HashMap<>();
        replacementMap.put("&", "&amp");
        replacementMap.put("<", "&lt");
        replacementMap.put(">", "&gt");

        StringBuffer stringBuffer = new StringBuffer();

        while (matcher.find()) {
            String wordToReplace = matcher.group();
            matcher.appendReplacement(stringBuffer, replacementMap.get(wordToReplace));
        }

        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
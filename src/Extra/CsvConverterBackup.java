package Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvConverterBackup {
    public static void main(String[] args) {
        System.out.println("*** Converts csv to html ***");

        String inputFileName = args[0];
        String outputFileName = args[1];

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

            boolean separatorMode = true;
            boolean isNewCell = true;
            boolean isEscapeQuotes = false;

            Map<String, String> replacementMap = new HashMap<>();
            replacementMap.put("&", "&amp;");
            replacementMap.put("<", "&lt;");
            replacementMap.put(">", "&gt;");

            writer.println(TABLE_OPEN_TAG);
            StringBuilder stringBuilder = new StringBuilder();
            String processedString;

            while (scanner.hasNextLine()) {
                processedString = getFormattedString(scanner.nextLine(), replacementMap);

                int beginIndex = 0;
                int currentCharIndex = 0;

                while (currentCharIndex < processedString.length()) {
                    char currentChar = processedString.charAt(currentCharIndex);
                    char nextChar = (currentCharIndex < processedString.length() - 1) ? processedString.charAt(currentCharIndex + 1) : END_OF_STRING;

                    if (currentCharIndex == 0 && isNewCell) {
                        stringBuilder.append(ROW_OPEN_TAG).append(END_OF_STRING);
                    }

                    // Обработка начала новой ячейки по флагу
                    if (isNewCell) {
                        stringBuilder.append(CELL_OPEN_TAG);

                        // Проверка и финализация ячейки, если она пустая
                        if (currentChar == SEPARATOR) {
                            if (nextChar == SEPARATOR) {
                                stringBuilder.append(CELL_CLOSE_TAG).append(END_OF_STRING);

                                ++currentCharIndex;
                                continue;
                            }

                            if (nextChar == END_OF_STRING) {
                                stringBuilder.append(CELL_CLOSE_TAG).append(END_OF_STRING).append(ROW_CLOSE_TAG);

                                writer.println(replaceEscapeQuotes(stringBuilder.toString()));
                                stringBuilder = new StringBuilder();

                                ++currentCharIndex;
                                continue;
                            }

                            ++currentCharIndex;
                            continue;
                        }

                        isNewCell = false;

                        // Определение индекса первого символа текста ячейки
                        // Если встречаем кавычки, то меняем режим чтения
                        if (currentChar == QUOTES) {
                            beginIndex = currentCharIndex + 1;
                            separatorMode = false;
                        } else {
                            beginIndex = currentCharIndex;
                        }

                        continue;
                    }

                    // Блок кода для режима чтения separatorMode, т.е. нет кавычек
                    // и проверяем следующий символ пока не встретим конец строки или разделитель
                    if (separatorMode) {
                        // Если nextChar - разделитель, финализируем ячейку и дописываем в stringBuilder
                        if (nextChar == SEPARATOR) {
                            stringBuilder.append(processedString, beginIndex, currentCharIndex + 1).append(CELL_CLOSE_TAG).append(END_OF_STRING);

                            isNewCell = true;
                            ++currentCharIndex;
                            continue;
                        }

                        // Если nextChar - конец строки, финализируем ячейку и дописываем в stringBuilder
                        if (nextChar == END_OF_STRING) {
                            stringBuilder.append(processedString, beginIndex, currentCharIndex + 1).append(CELL_CLOSE_TAG).append(END_OF_STRING).append(ROW_CLOSE_TAG);

                            writer.println(replaceEscapeQuotes(stringBuilder.toString()));
                            stringBuilder = new StringBuilder();

                            isNewCell = true;
                            ++currentCharIndex;
                            continue;
                        }

                        ++currentCharIndex;
                        continue;
                    }

                    // Блок кода для режима чтения !separatorMode, т.е. когда содержимое ячейки в кавычках
                    if (currentChar == QUOTES) {
                        // Если предыдущий символ были экранирующие кавычки,
                        // то эти кавычки нужно пропустить и выключить флаг,
                        // но если сразу за ними конец строки, добавляем в stringBuilder тэг разрыва строки.
                        if (isEscapeQuotes) {
                            isEscapeQuotes = false;

                            if (nextChar == END_OF_STRING) {
                                stringBuilder.append(processedString, beginIndex, currentCharIndex + 1).append(BREAK_LINE_TAG);
                            }

                            ++currentCharIndex;
                            continue;
                        }

                        // Если nextChar тоже кавычки, ставим флаг isEscapeQuotes и переходим на следующий символ
                        if (nextChar == QUOTES) {
                            isEscapeQuotes = true;
                            ++currentCharIndex;
                            continue;
                        }

                        // Если nextChar - разделитель, то финализируем ячейку и добавляем в stringBuilder
                        if (nextChar == SEPARATOR) {
                            stringBuilder.append(processedString, beginIndex, currentCharIndex).append(CELL_CLOSE_TAG).append(END_OF_STRING);

                            separatorMode = true;
                            isNewCell = true;
                            ++currentCharIndex;
                            continue;
                        }

                        // Если nextChar - конец строки, то финализируем ячейку и строку
                        // добавляем в stringBuilder и записываем в html-файл и сбрасываем stringBuilder
                        if (nextChar == END_OF_STRING) {
                            stringBuilder.append(processedString, beginIndex, currentCharIndex).append(CELL_CLOSE_TAG).append(END_OF_STRING).append(ROW_CLOSE_TAG);

                            writer.println(replaceEscapeQuotes(stringBuilder.toString()));
                            stringBuilder = new StringBuilder();

                            separatorMode = true;
                            isNewCell = true;
                            ++currentCharIndex;
                            continue;
                        }
                    }

                    // Если nextChar - конец строки, то вставляем тэг переноса строки
                    // и добавляем в stringBuilder.
                    // Далее строка заканчивается и читается следующая из файла.
                    if (nextChar == END_OF_STRING) {
                        stringBuilder.append(processedString, beginIndex, currentCharIndex + 1).append(BREAK_LINE_TAG);

                        ++currentCharIndex;
                        continue;
                    }

                    // Если ни одно условие выше не выполняется, то переходим к следующему символу
                    ++currentCharIndex;
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

    public static String getFormattedString(String inputString, Map<String, String> replacementMap) {
        Pattern pattern = Pattern.compile("[&<>]");
        Matcher matcher = pattern.matcher(inputString);

        StringBuffer stringBuffer = new StringBuffer();

        while (matcher.find()) {
            String wordToReplace = matcher.group();
            matcher.appendReplacement(stringBuffer, replacementMap.get(wordToReplace));
        }

        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
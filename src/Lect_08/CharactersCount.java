package Lect_08;

import java.util.Scanner;

public class CharactersCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Counts characters in a string ***");
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        int lettersCount = 0;
        int digitsCount = 0;
        int spacesCount = 0;
        int otherCharactersCount = 0;

        for (int i = 0; i < string.length(); ++i) {
            if (Character.isLetter(string.charAt(i))) {
                ++lettersCount;
            } else if (Character.isDigit(string.charAt(i))) {
                ++digitsCount;
            } else if (Character.isWhitespace(string.charAt(i))) {
                ++spacesCount;
            } else {
                ++otherCharactersCount;
            }
        }

        String lettersCountEnding = (lettersCount > 1) ? "s" : "";
        String digitsCountEnding = (digitsCount > 1) ? "s" : "";
        String spacesCountEnding = (spacesCount > 1) ? "s" : "";
        String otherCharactersCountEnding = (otherCharactersCount > 1) ? "s" : "";

        System.out.println("Your string consists of:");
        System.out.printf("%d letter%s%n", lettersCount, lettersCountEnding);
        System.out.printf("%d digit%s%n", digitsCount, digitsCountEnding);
        System.out.printf("%d whitespace%s%n", spacesCount, spacesCountEnding);
        System.out.printf("%d other character%s%n", otherCharactersCount, otherCharactersCountEnding);
    }
}
package JavaCourseTasks;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Determines whether a string is a palindrome (ignores all characters except letters) ***");
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        if (isPalindrome(string)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
    }

    public static boolean isPalindrome(String string) {
        if (string.length() == 0) {
            return true;
        }

        int firstCharIndex = 0;
        int lastCharIndex = string.length() - 1;
        char firstChar = string.charAt(firstCharIndex);
        char lastChar = string.charAt(lastCharIndex);

        while (lastCharIndex > firstCharIndex) {
            while (!Character.isLetter(firstChar) && firstCharIndex < lastCharIndex) {
                ++firstCharIndex;
                firstChar = Character.toLowerCase(string.charAt(firstCharIndex));
            }

            while (!Character.isLetter(lastChar) && lastCharIndex > firstCharIndex) {
                --lastCharIndex;
                lastChar = Character.toLowerCase(string.charAt(lastCharIndex));
            }

            if (Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar)) {
                return false;
            }

            ++firstCharIndex;
            --lastCharIndex;
        }

        return true;
    }
}
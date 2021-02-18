package JavaCourseTasks;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        if (string.length() == 0) {
            System.out.println("The string is empty - no palindromes.");
        } else {
            boolean isPalindrome = true;
            int firstCharIndex = 0;
            int lastCharIndex = string.length() - 1;

            char firstChar = Character.toLowerCase(string.charAt(firstCharIndex));
            char lastChar = Character.toLowerCase(string.charAt(lastCharIndex));

            while (lastCharIndex - firstCharIndex > 0) {
                while (!Character.isLetter(firstChar) && firstCharIndex < lastCharIndex) {
                    ++firstCharIndex;
                    firstChar = Character.toLowerCase(string.charAt(firstCharIndex));
                }

                while (!Character.isLetter(lastChar) && lastCharIndex > firstCharIndex) {
                    --lastCharIndex;
                    lastChar = Character.toLowerCase(string.charAt(lastCharIndex));
                }

                if (firstChar != lastChar) {
                    isPalindrome = false;
                    break;
                }

                ++firstCharIndex;
                --lastCharIndex;
            }

            if (isPalindrome) {
                System.out.println("This is a palindrome.");
            } else {
                System.out.println("This is NOT a palindrome.");
            }
        }
    }
}
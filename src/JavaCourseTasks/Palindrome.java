package JavaCourseTasks;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Determines whether a string is a palindrome (ignores all characters except letters) ***");
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        if (!string.matches("(?i).*[a-zа-я].*")) {
            System.out.println("The string has no letters.");
        } else {
            boolean isPalindrome = true;
            int firstCharIndex = 0;
            int lastCharIndex = string.length() - 1;

            while (lastCharIndex - firstCharIndex > 0) {
                char firstChar = string.charAt(firstCharIndex);
                char lastChar = string.charAt(lastCharIndex);

                while (!Character.isLetter(firstChar) && firstCharIndex < lastCharIndex) {
                    ++firstCharIndex;
                    firstChar = Character.toLowerCase(string.charAt(firstCharIndex));
                }

                while (!Character.isLetter(lastChar) && lastCharIndex > firstCharIndex) {
                    --lastCharIndex;
                    lastChar = Character.toLowerCase(string.charAt(lastCharIndex));
                }

                if (Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar)) {
                    isPalindrome = false;
                    break;
                }

                ++firstCharIndex;
                --lastCharIndex;
            }

            if (isPalindrome) {
                System.out.println("The string is a palindrome.");
            } else {
                System.out.println("The string is NOT a palindrome.");
            }
        }
    }
}
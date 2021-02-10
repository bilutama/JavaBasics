package JavaCourseTasks;

import java.util.Scanner;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String string = scanner.nextLine();

        string = string.toLowerCase().replaceAll("[^A-Za-z]+", "");

        if (string.length() < 2) {
            System.out.println("No palindromes for the string.");
        } else if (string.length() == 2) {
            if (string.charAt(0) == string.charAt(1)) {
                System.out.printf("Palindrome: %s%n", string);
            } else {
                System.out.println("No palindromes for the string.");
            }
        } else {
            for (int charIndex = 1; charIndex < string.length() - 1; ++charIndex) {
                if ((string.charAt(charIndex) != string.charAt(charIndex - 1)) && (string.charAt(charIndex + 1) != string.charAt(charIndex - 1))) {
                    continue;
                }

                int left = charIndex - 1;
                int right = charIndex;

                if (string.charAt(charIndex - 1) == string.charAt(charIndex + 1)) {
                    right = charIndex + 1;
                }

                while (left > 0 && right < string.length() - 1) {
                    if (string.charAt(left - 1) == string.charAt(right + 1)) {
                        --left;
                        ++right;
                        continue;
                    }
                    break;
                }

                String palindrome = string.substring(left, right + 1);
                System.out.printf("Palindrome: %s%n", palindrome);
            }
        }
    }
}
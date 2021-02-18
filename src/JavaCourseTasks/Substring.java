package JavaCourseTasks;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Calculates length of the longest substring ***");
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        if (string.length() == 0) {
            System.out.println("The string is empty");
        } else {
            int SubstringLength = 1;
            int maxSubstringLength = 1;

            for (int i = 1; i < string.length(); ++i) {
                char nextChar = Character.toLowerCase(string.charAt(i));
                char previousChar = Character.toLowerCase(string.charAt(i - 1));

                if (nextChar == previousChar) {
                    ++SubstringLength;

                    if (i == string.length() - 1 && SubstringLength > maxSubstringLength) {
                        maxSubstringLength = SubstringLength;
                    }
                } else {
                    if (SubstringLength > maxSubstringLength) {
                        maxSubstringLength = SubstringLength;
                    }

                    SubstringLength = 1;
                }
            }
            System.out.printf("The longest substring of repeated characters has %d characters", maxSubstringLength);
        }
    }
}
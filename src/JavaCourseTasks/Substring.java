package JavaCourseTasks;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Returns the maximum count of repeating characters in a string ***");
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        System.out.printf("Maximum substring length of repeating characters is %d%n", getMaximumSubstringLength(string));
    }

    public static int getMaximumSubstringLength(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }

        int substringLength = 1;
        int maximumSubstringLength = 1;

        for (int i = 1; i < string.length(); ++i) {
            char currentChar = Character.toLowerCase(string.charAt(i));
            char previousChar = Character.toLowerCase(string.charAt(i - 1));

            if (currentChar == previousChar) {
                ++substringLength;

                // check if the current char the last in the string
                if (i == string.length() - 1 && substringLength > maximumSubstringLength) {
                    maximumSubstringLength = substringLength;
                }
            } else {
                if (substringLength > maximumSubstringLength) {
                    maximumSubstringLength = substringLength;
                }

                // return if current maxSubstringLength is longer than the end of the string
                if (maximumSubstringLength >= string.length() - i) {
                    return maximumSubstringLength;
                }

                substringLength = 1;
            }
        }

        return maximumSubstringLength;
    }
}
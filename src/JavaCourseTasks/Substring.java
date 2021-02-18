package JavaCourseTasks;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Returns the maximum count of repeating characters in a string ***");
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        if (string.length() == 0) {
            System.out.println("The string is empty");
        } else {
            int SubstringLength = 1;
            int maximumSubstringLength = 1;

            for (int i = 1; i < string.length(); ++i) {
                char thisChar = Character.toLowerCase(string.charAt(i));
                char previousChar = Character.toLowerCase(string.charAt(i - 1));

                if (thisChar == previousChar) {
                    ++SubstringLength;

                    if (i == string.length() - 1 && SubstringLength > maximumSubstringLength) {
                        maximumSubstringLength = SubstringLength;
                    }
                } else {
                    if (SubstringLength > maximumSubstringLength) {
                        maximumSubstringLength = SubstringLength;
                    }

                    SubstringLength = 1;
                }
            }
            System.out.printf("The maximum count of repeating characters is %d", maximumSubstringLength);
        }
    }
}
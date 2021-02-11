package JavaCourseTasks;

public class LongestSubstring {
    public static void main(String[] args) {
        String string1 = "aaaar";
        String string2 = "aaaaaaaaaar";

        if (string1.length() == 0 || string2.length() == 0) {
            System.out.println("One of strings is empty");
            return;
        }

        String longString;
        String shortString;

        if (string1.length() >= string2.length()) {
            longString = string1;
            shortString = string2;
        } else {
            longString = string2;
            shortString = string1;
        }

        String maximumSubstring = "";
        int maximumSubstringLenght = 0;

        for (int i = 0; i < longString.length(); ++i) {
            for (int j = 0; j < shortString.length(); ++j) {
                if (longString.charAt(i) == shortString.charAt(j)) {
                    int subStringShift = 1;

                    while ((i + subStringShift < longString.length()) &&
                            (j + subStringShift < shortString.length()) &&
                            (longString.charAt(i + subStringShift) == shortString.charAt(j + subStringShift))) {
                        ++subStringShift;
                    }

                    String subString = longString.substring(i, i + subStringShift);
                    if (subString.length() > maximumSubstringLenght) {
                        maximumSubstring = subString;
                        maximumSubstringLenght = subString.length();
                    }
                }
            }
        }

        System.out.printf("The longest common substring is: \"%s\"%n", maximumSubstring);
        System.out.printf("It's length is %d%n", maximumSubstring.length());
    }
}
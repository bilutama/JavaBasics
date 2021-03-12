package Lect_12;

public class StringSplitter {
    public static void main(String[] args) throws Exception {
        String string = "1, 2, 3, 4, 5";
        String[] numberStrings = string.split(",");

        try {
            int sum = 0;

            for (String s : numberStrings) {
                sum += Integer.parseInt(s.trim());
            }

            System.out.printf("Sum of numbers in the string \"%s\" = %d", string, sum);
        } catch (Exception exception) {
            System.out.println("Unable to parse numbers from the string");
        }
    }
}
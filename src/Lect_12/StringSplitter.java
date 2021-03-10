package Lect_12;

public class StringSplitter {
    public static void main(String[] args) throws Exception {
        String string = "1, 2, 3, 4, 5";

        String[] stringArray = string.split(",");
        int[] numbers = new int[stringArray.length];
        int sum = 0;

        try {
            for (String s : stringArray) {
                sum += Integer.parseInt(s.trim());
            }

            System.out.println(sum);
        } catch (Exception exception) {
            System.out.println("Unable to parse numbers from the string");
        }
    }
}
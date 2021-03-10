package Lect_12;

public class StringSplitter {
    public static void main(String[] args) throws Exception {
        String string = "1, 2, 3, 4, 5";
        String[] stringsArray = string.split(",");

        try {
            int sum = 0;

            for (String s : stringsArray) {
                sum += Integer.parseInt(s.trim());
            }

            System.out.println(sum);
        } catch (Exception exception) {
            System.out.println("Unable to parse numbers from the string");
        }
    }
}
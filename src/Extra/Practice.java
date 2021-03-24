package Extra;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Practice {
    public static void main(String[] args) {
        String string1 = "\"Vasya\",Pet\"\"ya,Kolya,\"Karl\"";
        //String string2 = "\"Vas\"\",ya\",Petya,Kolya,Karl";
        //String string3 = "\"Vasya\",Petya,Kolya,\"Karl\"";

        Pattern pattern = Pattern.compile("^((\"(?:[^\"]|\"\")*\"|[^,]*)(,(\"(?:[^\"]|\"\")*\"|[^,]*))*)$");
        //Pattern pattern = Pattern.compile("(?:^|\")([^\"]*)(?:$|\")");

        //String[] words = string1.split(",");
        /*for (String w : words) {
            System.out.println(w);
        }*/

        Matcher matcher = pattern.matcher(string1);
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
        }

        /*
        matcher = pattern.matcher(string2);
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
        }

        matcher = pattern.matcher(string3);
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
        }*/
    }
}
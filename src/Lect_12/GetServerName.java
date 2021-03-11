package Lect_12;

public class GetServerName {
    public static void main(String[] args) {
        System.out.println("*** Returns server's name from URL ***");

        String testURL1 = "http://SomeServerName/abcd/dfdf.htm?dfdf=dfdf";
        System.out.println(getServerNameFromURL(testURL1));

        String testURL2 = "http://SomeServerName";
        System.out.println(getServerNameFromURL(testURL2));

        String testURL3 = "http://";
        System.out.println(getServerNameFromURL(testURL3));
    }

    public static String getServerNameFromURL(String inputUrl) {
        if (inputUrl.isEmpty()) {
            return "";
        }

        String serverNamePrefix = "://";
        int beginIndex = inputUrl.indexOf(serverNamePrefix);

        if (beginIndex == -1) {
            return "";
        }
        
        beginIndex += serverNamePrefix.length();

        String serverNamePostfix = "/";
        int endIndex = inputUrl.indexOf(serverNamePostfix, beginIndex);

        if (endIndex == -1) {
            endIndex = inputUrl.length();
        }

        return inputUrl.substring(beginIndex, endIndex);
    }
}

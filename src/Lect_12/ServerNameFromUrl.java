package Lect_12;

public class ServerNameFromUrl {
    public static void main(String[] args) {
        System.out.println("*** Returns server's name from Url ***");

        String testUrl1 = "http://SomeServerName/abcd/dfdf.htm?dfdf=dfdf";
        System.out.println(getServerNameFromUrl(testUrl1));

        String testUrl2 = "http://SomeServerName";
        System.out.println(getServerNameFromUrl(testUrl2));

        String testUrl3 = "http://";
        System.out.println(getServerNameFromUrl(testUrl3));
    }

    public static String getServerNameFromUrl(String inputUrl) {
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
package JavaCourseTasks;

public class NextDate {
    public static void main(String[] args) {

    }

    private static int getDaysInYear (int year) {
        int daysInYear = 366;

        if (year % 4 != 0) {
            daysInYear = 365;
        } else if ((year % 100 != 0) && (year % 400 == 0)) {
            daysInYear = 365;
        }

        return daysInYear;
    }

}
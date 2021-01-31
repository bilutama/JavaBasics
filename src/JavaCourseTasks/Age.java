package JavaCourseTasks;

import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        System.out.println("*** Определение возраста ***");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваш возраст: ");
        int age = scanner.nextInt();

        if (age > 0 && age <= 112) {
            String ageTextEnding;

            if ((age / 10) % 10 == 1) {
                ageTextEnding = "лет";
            } else if (age % 10 > 4) {
                ageTextEnding = "лет";
            } else if (age % 10 == 1) {
                ageTextEnding = "год";
            } else {
                ageTextEnding = "года";
            }

            System.out.printf("Вам %d %s", age, ageTextEnding);
        } else if (age <= 0) {
            System.out.println("Вы слишком малы.");
        } else {
            System.out.println("Вы слишком стары.");
        }
    }
}
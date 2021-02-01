package JavaCourseTasks;

import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        System.out.println("*** Определение возраста ***");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        if (age > 112) {
            System.out.println("Вы слишком стары.");
        } else if (age <= 0) {
            System.out.println("Вы слишком малы.");
        } else {
            String ageTextEnding;

            int ageLastDigit = age % 10;
            
            if ((age / 10) % 10 == 1 || (ageLastDigit > 4) || (ageLastDigit == 0)) {
                ageTextEnding = "лет";
            } else if (ageLastDigit == 1) {
                ageTextEnding = "год";
            } else {
                ageTextEnding = "года";
            }

            System.out.printf("Вам %d %s%n", age, ageTextEnding);
        }
    }
}
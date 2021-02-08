package JavaCourseTasks;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random randomizer = new Random();
        int conceivedNumber = randomizer.nextInt(100) + 1;

        System.out.println("The number from 1 to 100 is conceived.");
        System.out.println("Try to guess it: ");

        int i = 1;

        while (true) {
            int userNumber = scanner.nextInt();

            if (userNumber < conceivedNumber) {
                System.out.print("The number is bigger, try again: ");
            } else if (userNumber > conceivedNumber) {
                System.out.print("The number is smaller, try again: ");
            } else {
                System.out.printf("This is a win! You've successfully guessed it on %d try.", i);
                break;
            }
            
            ++i;
        }
    }
}

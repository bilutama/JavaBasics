package Lect_05;

import java.util.Scanner;

public class Break {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Guess the string ***");

        String secretString = "Breakthru";

        while (true) {
            System.out.print("Enter a string: ");
            String userString = scanner.nextLine();

            if (userString.equals(secretString)) {
                break;
            }
        }
    }
}
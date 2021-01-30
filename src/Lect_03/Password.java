package Lect_03;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        System.out.println("*** Validates your password ***");

        Scanner scanner = new Scanner(System.in);

        String password = "ThePassword";

        System.out.print("Enter a password: ");
        String passwordFromUser = scanner.nextLine();

        if (password.length() == passwordFromUser.length()) {
            if (password.equals(passwordFromUser)) {
                System.out.println("Password ok.");
            } else {
                System.out.println("Password is wrong.");
            }
        } else if (password.length() > passwordFromUser.length()) {
            System.out.println("Your password is too short.");
        } else {
            System.out.println("Your password is too long.");
        }
    }
}
package Lect_01_02;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Как вас зовут?");
        String userName = scanner.nextLine();

        System.out.printf("Привет, %s!%n", userName);
    }
}
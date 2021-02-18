package Lect_08;

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        //boolean index = string.matches("(?i).*[a-zа-я].*");
        boolean index = string.matches("(?i).*[a-zа-я].*");
        System.out.print(index);
    }
}

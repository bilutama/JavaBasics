package Lect_06;

import java.util.Scanner;

public class PrintAndReadClass {
    public static void main(String[] args) {
        int variable = printAndRead("Enter a number: ");
        System.out.printf("Value = %d%n", variable);

        variable = printAndRead("Enter a number again: ");
        System.out.printf("Value = %d%n", variable);

        String inputPrompt = "Test the function \"printAndRead\": ";

        variable = printAndRead(inputPrompt);
        System.out.printf("Value = %d%n", variable);
    }

    public static int printAndRead (String inputPrompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(inputPrompt);
        return scanner.nextInt();
    }
}
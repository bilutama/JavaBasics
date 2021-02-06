package ClassTasks;

import com.sun.source.tree.CaseTree;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a command: ");
        String userCommand = scanner.nextLine();

        switch (userCommand) {
            case "print":
                System.out.print("Enter your message: ");
                String userMessage = scanner.nextLine();

                System.out.printf("MESSAGE: %s%n", userMessage);
                break;
            case "sum":
                System.out.print("The first number: ");
                double firstNumber = scanner.nextDouble();

                System.out.print("The second number: ");
                double secondNumber = scanner.nextDouble();

                System.out.printf("Sum = %.3f%n", firstNumber + secondNumber);
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}

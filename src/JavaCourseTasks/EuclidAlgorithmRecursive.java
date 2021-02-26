package JavaCourseTasks;

import java.util.Scanner;

public class EuclidAlgorithmRecursive {
    public static void main(String[] args) {
        System.out.println("*** Euclid Algorithm (GCD for two numbers) ***");

        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Euclid Algorithm (GCD for two numbers) ***");

        System.out.print("The first number: ");
        int number1 = Math.abs(scanner.nextInt());

        System.out.print("The second number: ");
        int number2 = Math.abs(scanner.nextInt());

        try {
            System.out.printf("The greatest common divisor = %d", getGreatestCommonDivisor(number1, number2));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int getGreatestCommonDivisor(int maximumNumber, int minimumNumber) throws Exception {
        if (minimumNumber == 0 && maximumNumber == 0) {
            throw new Exception("no GCD when both numbers equal zeros");
        }

        minimumNumber = Math.abs(minimumNumber);
        maximumNumber = Math.abs(maximumNumber);

        if (minimumNumber == 0) {
            return maximumNumber;
        }

        return getGreatestCommonDivisor(minimumNumber, maximumNumber % minimumNumber);
    }
}
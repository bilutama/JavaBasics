package JavaCourseTasks;

import java.util.Scanner;

public class EuclidAlgorithmRecursive {
    public static void main(String[] args) {
        System.out.println("*** Euclid Algorithm (GCD for two numbers) ***");

        Scanner scanner = new Scanner(System.in);

        int number1 = 0;

        System.out.print("The first number: ");
        number1 = scanner.nextInt();

        int number2 = 0;

        System.out.print("The last number: ");
        number2 = scanner.nextInt();

        try {
            int greatestCommonDivisor = getGreatestCommonDivisor(number1, number2);
            System.out.printf("The greatest common divisor = %d", greatestCommonDivisor);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int getGreatestCommonDivisor(int maximumNumber, int minimumNumber) throws Exception {
        if (minimumNumber == 0 && maximumNumber == 0) {
            throw new Exception("ERROR: no GCD for two 0");
        }

        minimumNumber = Math.abs(minimumNumber);
        maximumNumber = Math.abs(maximumNumber);

        if (minimumNumber == 0) {
            return maximumNumber;
        }

        return getGreatestCommonDivisor(minimumNumber, maximumNumber % minimumNumber);
    }
}
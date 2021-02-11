package JavaCourseTasks;

import java.util.Scanner;
import java.text.DecimalFormat;

public class BankDeposit {
    public static void main(String[] args) {
        System.out.println("*** Calculates a bank deposit  ***");

        Scanner scanner = new Scanner(System.in);

        double deposit = -1.0;

        while (deposit <= 0) {
            System.out.print("Your deposit, USD: ");
            deposit = scanner.nextDouble();
        }

        double percent = -1.0;
        final int percentToFractionCoefficient = 100;

        while (percent < 0.0) {
            System.out.print("Annual profit rate, %: ");
            percent = scanner.nextDouble();
        }

        double annualInterestRate = percent / percentToFractionCoefficient;

        int monthsCount = -1;

        while (monthsCount < 1) {
            System.out.print("Months to return: ");
            monthsCount = scanner.nextInt();
        }

        System.out.println("_________________________________________________________");

        System.out.print("Month | ");
        System.out.print("Sum @ start, USD | ");
        System.out.print("Sum @ end, USD | ");
        System.out.printf("Interest, USD%n");

        double depositStateStart = deposit;
        double depositStateEnd = 0;

        final int monthsCountInYear = 12;

        double depositMultiplier = (1 + annualInterestRate / monthsCountInYear);

        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");

        for (int i = 1; i <= monthsCount; ++i) {
            System.out.printf("%5d |", i);
            System.out.printf("%15s ", decimalFormat.format(depositStateStart));

            depositStateEnd = depositStateStart * depositMultiplier;
            System.out.printf("%14s", decimalFormat.format(depositStateEnd));

            double profit = depositStateEnd - depositStateStart;
            System.out.printf("%16s%n", decimalFormat.format(profit));

            depositStateStart = depositStateEnd;
        }

        System.out.println("_________________________________________________________");
        System.out.printf("Your deposit at the end of the period, USD: %s%n", decimalFormat.format(depositStateEnd));

        double totalProfit = depositStateEnd - deposit;
        System.out.printf("Total profit per period, USD: %s%n", decimalFormat.format(totalProfit));
    }
}
package Lect_06;

import java.util.Scanner;

public class OrderCost {
    private static double DISCOUNT_FOR_AMOUNT = 0.05;
    private static double DISCOUNT_FOR_TOTAL_ORDER_COST = 0.05;
    private static int AMOUNT_FOR_DISCOUNT = 10;
    private static double ORDER_COST_FOR_DISCOUNT = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** E-Market ***");

        double baguettePrice = 70.0;
        System.out.printf("Baguette - RUR %.1f%n", baguettePrice);

        double milkPrice = 80.0;
        System.out.printf("Bottle of milk - RUR %.1f%n", milkPrice);

        int baguettesCount = -1;

        while (baguettesCount < 0) {
            System.out.print("How many baguettes: ");
            baguettesCount = scanner.nextInt();
        }

        int milkBottlesCount = -1;

        while (milkBottlesCount < 0) {
            System.out.print("How many bottles of milk: ");
            milkBottlesCount = scanner.nextInt();
        }

        System.out.printf("Your order costs RUR %.1f%n", getOrderCost(baguettesCount, milkBottlesCount, baguettePrice, milkPrice));
    }

    public static double getOrderCost(int productCount1, int productCount2, double productPrice1, double productPrice2) {
        int productsCountInOrder = productCount1 + productCount2;
        double orderCostWithoutDiscount = productCount1 * productPrice1 + productCount2 * productPrice2;
        double discount = 0.0;

        if (productsCountInOrder >= AMOUNT_FOR_DISCOUNT) {
            discount += DISCOUNT_FOR_AMOUNT;
        }

        if (orderCostWithoutDiscount >= ORDER_COST_FOR_DISCOUNT) {
            discount += DISCOUNT_FOR_TOTAL_ORDER_COST;
        }

        System.out.printf("Discount is %.1f%% (RUR %.1f)%n", discount * 100, orderCostWithoutDiscount * discount);
        return orderCostWithoutDiscount * (1 - discount);
    }
}
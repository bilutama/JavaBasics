package Lect_06;

import java.util.Scanner;

public class OrderCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Electronics E-Store ***");

        double baguettePrice = 70.0;
        System.out.printf("Baguette - RUR %.1f%n", baguettePrice);

        double milkPrice = 80.0;
        System.out.printf("Bottle of milk - RUR $%.1f%n", milkPrice);

        System.out.print("How many baguettes: ");
        int baguettesCount = scanner.nextInt();

        System.out.print("How many bottles of milk: ");
        int milkBottlesCount = scanner.nextInt();

        System.out.printf("Your order costs: $%.1f%n", getOrderCost(baguettesCount, milkBottlesCount, baguettePrice, milkPrice));
    }

    public static double getOrderCost(int productCount1, int productCount2, double productPrice1, double productPrice2){
        double orderCostWithoutDiscount = productCount1 * productPrice1 + productCount2 * productPrice2;
        double discount = 0.0;

        if (productCount1 + productCount2 >= 10){
            discount += 0.05;
        }

        if (orderCostWithoutDiscount >= 1000) {
            discount +=0.05;
        }

        return orderCostWithoutDiscount * (1 - discount);
    }
}
package Lect_06;

import java.util.Scanner;

public class OrderCost {
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

    public static double getOrderCost(int productCount1, int productCount2, double productPrice1, double productPrice2){
        int productsCountInOrder = productCount1 + productCount2;
        double orderCostWithoutDiscount = productCount1 * productPrice1 + productCount2 * productPrice2;
        double discount = 0.0;

        if (productsCountInOrder >= 10){
            discount += 0.05;
        }

        if (orderCostWithoutDiscount >= 1000) {
            discount +=0.05;
        }

        return orderCostWithoutDiscount * (1 - discount);
    }
}
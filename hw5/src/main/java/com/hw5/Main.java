package com.hw5;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();

        FoodItem burger = new Burger(8.0);
        FoodItem fries = new Fries(4.0);

        FoodItem baconBurger = new Bacon(burger, 1.0);
        FoodItem cheeseBurger = new Cheese(burger, 1.0);
        FoodItem lettuceBurger = new Lettuce(burger, 1.0);
        FoodItem baconAndCheeseBurger = new Cheese(baconBurger, 1.0); //add 1 more to the price

        order.addFoodItem(baconAndCheeseBurger);
        order.addFoodItem(fries);

        System.out.println("Total cost before discount: $" + order.getPrice());

        LoyaltyStatus loyaltyStatus= new LoyaltyStatus(); // Apply 10% discount
		System.out.println("Total cost after discount: $" + loyaltyStatus.discount(order.getPrice()));
    }
}
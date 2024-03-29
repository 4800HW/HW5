package com.hw5;

import java.util.ArrayList;
import java.util.List;

public interface FoodItem {
    double getPrice();
}

//decorator
abstract class Topping implements FoodItem {
    protected FoodItem foodItem;

    public Topping(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}

class Burger implements FoodItem {
    private double price;

    public Burger(double price)
    {
        this.price = price;
    }

    @Override
    public double getPrice()
    {
        return price;
    }
}

    class Fries implements FoodItem {
        private double price;

        public Fries(double price) {
            this.price = price;
        }
    
        @Override
        public double getPrice() {
            return price;
        }
    }

    //toppings
    class Cheese extends Topping {
        private double price;
    
        public Cheese(FoodItem foodItem, double price) {
            super(foodItem);
            this.price = price;
        }
    
        @Override
        public double getPrice() {
            return foodItem.getPrice() + price;
        }
    }

    class Lettuce extends Topping {
        private double price;
    
        public Lettuce(FoodItem foodItem, double price) {
            super(foodItem);
            this.price = price;
        }
    
        @Override
        public double getPrice() {
            return foodItem.getPrice() + price;
        }
    }

    class Bacon extends Topping {
        private double price;
    
        public Bacon(FoodItem foodItem, double price) {
            super(foodItem);
            this.price = price;
        }
    
        @Override
        public double getPrice() {
            return foodItem.getPrice() + price;
        }
    }

    class Order {
        private List<FoodItem> orderList = new ArrayList<>();
    
        public void addFoodItem(FoodItem foodItem) {
            orderList.add(foodItem);
        }
    
        public double getPrice() {
            double totalCost = 0.0;
            for (FoodItem foodItem : orderList) {
                totalCost += foodItem.getPrice();
            }
            return totalCost;
        }
    }

    class LoyaltyStatus {
        private double discount = 0.1; //fixed 10% discount
    
        public double discount(double totalCost) {
            return totalCost * (1 - discount);
        }
    }

    // //junit test
    // public class BurgerTest {
    //     @Test
    //     Burger burger = new Burger(8.0);
    // }

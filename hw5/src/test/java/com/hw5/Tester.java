package com.hw5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Tester 
{
        FoodItem burger = new Burger(8.0);
        FoodItem fries = new Fries(4.0);

        FoodItem burgerWithBacon = new Bacon(burger, 1.0);
        FoodItem burgerWithBaconAndLettuce = new Lettuce(burgerWithBacon, 1.0);

        Order foodOrder = new Order();

        @Test
        public void checkBurgerPrice()
        {
            assertEquals(8.0, burger.getPrice(), 0.01);
        }

        @Test
        public void checkFriesPrice()
        {
            assertEquals(4.0, fries.getPrice(), 0.01);
        }

        @Test
        public void checkBurgerBaconPrice()
       {
            assertEquals(9.0, burgerWithBacon.getPrice(), 0.01);
       }

       @Test
       public void checkBurgerBaconAndLettucePrice()
      {
           assertEquals(10.0, burgerWithBaconAndLettuce.getPrice(), 0.01);
      }

      @Test
      public void checkDiscountPrice()
      {
        foodOrder.addFoodItem(burgerWithBaconAndLettuce);
        LoyaltyStatus status = new LoyaltyStatus();
        double discountPrice = status.discount(foodOrder.getPrice());

        assertEquals(9, discountPrice, 0.01);
      }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;

import java.util.ArrayList;
import java.util.List;

class MenuItem {
    String name;
    String type;
    double price;

    MenuItem(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}

class CoffeeShop {
    String name;
    List<MenuItem> menu;
    List<String> orders;

    CoffeeShop(String name, List<MenuItem> menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<>();
    }

    String addOrder(String itemName) {
        for (MenuItem item : menu) {
            if (item.name.equals(itemName)) {
                orders.add(itemName);
                return "Order added: " + itemName;
            }
        }
        return "This item is currently unavailable!";
    }

    String fulfillOrder() {
        if (!orders.isEmpty()) {
            String item = orders.remove(0);
            return "The " + item + " is ready!";
        }
        return "All orders have been fulfilled!";
    }

    List<String> listOrders() {
        return orders;
    }

    double dueAmount() {
        double totalAmount = 0.0;
        for (String item : orders) {
            for (MenuItem menuItem : menu) {
                if (menuItem.name.equals(item)) {
                    totalAmount += menuItem.price;
                    break;
                }
            }
        }
        return totalAmount;
    }

    String cheapestItem() {
        if (menu.isEmpty()) {
            return "No items on the menu!";
        }
        MenuItem cheapest = menu.get(0);
        for (MenuItem item : menu) {
            if (item.price < cheapest.price) {
                cheapest = item;
            }
        }
        return cheapest.name;
    }

    List<String> drinksOnly() {
        List<String> drinks = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.type.equals("drink")) {
                drinks.add(item.name);
            }
        }
        return drinks;
    }

    List<String> foodOnly() {
        List<String> food = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.type.equals("food")) {
                food.add(item.name);
            }
        }
        return food;
    }
}

public class Mavenproject3 {
    public static void main(String[] args) {
        // Create the menu items
        MenuItem item1 = new MenuItem("Cappuccino", "drink", 3.99);
        MenuItem item2 = new MenuItem("Croissant", "food", 2.49);
        MenuItem item3 = new MenuItem("Latte", "drink", 4.49);
        MenuItem item4 = new MenuItem("Muffin", "food", 1.99);

        // Create the coffee shop
        List<MenuItem> menu = new ArrayList<>();
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);

        CoffeeShop coffeeShop = new CoffeeShop("My Coffee Shop", menu);

        // Add orders
        System.out.println(coffeeShop.addOrder("Cappuccino"));
        System.out.println(coffeeShop.addOrder("Latte"));
        System.out.println(coffeeShop.addOrder("Espresso")); // Unavailable item

        // Fulfill orders
        System.out.println(coffeeShop.fulfillOrder());
        System.out.println(coffeeShop.fulfillOrder());
        System.out.println(coffeeShop.fulfillOrder()); // All orders fulfilled

        // List orders
        System.out.println("Orders: " + coffeeShop.listOrders());

        // Due amount
        System.out.println("Due amount: $" + coffeeShop.dueAmount());

        // Cheapest item
        System.out.println("Cheapest item: " + coffeeShop.cheapestItem());

        // Drinks only
        System.out.println("Drinks only: " + coffeeShop.drinksOnly());

        // Food only
        System.out.println("Food only: " + coffeeShop.foodOnly());
    }
}



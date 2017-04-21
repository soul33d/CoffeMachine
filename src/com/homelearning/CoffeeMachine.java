package com.homelearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CoffeeMachine {
    private List<Drink> drinks;
    private PriceParser priceParser;

    CoffeeMachine() {
        drinks = new ArrayList<>();
        priceParser = new PriceParser();
        loadDrinks();
        printAvailableDrinks(readFromInput());
    }

    private void loadDrinks() {
        drinks.add(new Drink("Espresso", 600));
        drinks.add(new Drink("Americano", 700));
        drinks.add(new Drink("Cappuccino", 800));
        drinks.add(new Drink("White coffee", 800));
        drinks.add(new Drink("Latte", 900));
    }

    private int readFromInput(){
        System.out.println("Put money in the bill acceptor please");
        Scanner scanner = new Scanner(System.in);
        int money;
        if (scanner.hasNext()){
            money = priceParser.parseMoney(scanner.next());
        } else money = 0;
        scanner.close();
        return money;
    }

    private void printAvailableDrinks(int money){
        for (Drink drink : drinks) {
            if (drink.getPrice() <= money){
                String shortChange = priceParser.showPrice(money - drink.getPrice());
                System.out.println(drink.getName() + "\n short change: " + shortChange);
            }
        }
    }
}

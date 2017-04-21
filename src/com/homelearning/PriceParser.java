package com.homelearning;

class PriceParser {

    int parseMoney(String line){
        String result;
        if (line.contains(".") || line.contains(",")) {
            result = line.replaceAll("[.,]", "");
        } else result = line + "00";
        return Integer.valueOf(result);
    }

    String showPrice(int money){
        String price = String.valueOf(money);
        String dollars;
        String  cents;
        if (money < 100) dollars = "0";
        else dollars = price.substring(0, price.length() - 2);
        if (money < 10) cents = "0" + money;
        else cents = price.substring(price.length()-2, price.length());
        return "$" + dollars + "." + cents;
    }
}

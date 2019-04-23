package com.bogdan.kolomiiets.tasks;

import java.util.HashMap;
import java.util.Map;

public class Task_06_MostCommonSymbol {
    protected static String needToCheck = "aaAAsd***** @@@@@@@@@@@@...../,.,";
    protected static char symbol = ' ';

    public static void main(String[] args) {
        System.out.println(checkCommonSymbol(needToCheck));
    }

    protected static String checkCommonSymbol(String forTest) {
        //create Map for symbols
        Map<Character, Integer> characterMap = new HashMap<>();
        //try put each symbol into Map. If symbol exist - increment int value
        for (char ch : forTest.toLowerCase().toCharArray()) {
            characterMap.put(ch, characterMap.containsKey(ch) ? characterMap.get(ch) + 1 : 1);
        }

        int count = 0;

        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            if (count < entry.getValue()) {
                symbol = entry.getKey();
                count = entry.getValue();
            }
        }

        if (count > 0) {
            return "The most common symbol in string is: \"" + symbol + "\"";
        } else return "String empty";
    }
}

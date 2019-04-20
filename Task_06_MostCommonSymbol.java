package com.bogdan.kolomiiets.tasks;

import java.util.HashMap;
import java.util.Map;

public class Task_06_MostCommonSymbol {
    private static String needToCheck = "aaAAsd*****                    ........../,.,";

    public static void main(String[] args) {
        System.out.println(CommonSymbol(needToCheck));
    }

    private static String CommonSymbol(String forTest) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (char ch : forTest.toLowerCase().toCharArray()) {
            characterMap.put(ch, characterMap.containsKey(ch) ? characterMap.get(ch) + 1 : 1);
        }

        char symbol = ' ';
        int count = 0;

        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            if (count < entry.getValue()) {
                symbol = entry.getKey();
                count = entry.getValue();
            }
        }
        return "The most common symbol in string is: \"" + symbol + "\"";
    }
}

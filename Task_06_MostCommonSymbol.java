package com.bogdan.kolomiiets.tasks;

public class Task_06_MostCommonSymbol {
    private static String needToCheck = "aaAsd ./,.,";

    public static void main(String[] args) {
        System.out.println(CommonSymbol(needToCheck));
    }

    private static String CommonSymbol(String forTest){
        for (char ch : forTest.toLowerCase().toCharArray()) {

        }
        return "The most common symbol in string is: ";
    }
}

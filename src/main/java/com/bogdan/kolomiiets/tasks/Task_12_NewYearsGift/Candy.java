package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

public class Candy implements Candies {
    private String candyName;
    private double candyWeightGramme;

    public Candy(String candyName, double candyWeightGramme) {
        this.candyName = candyName;
        this.candyWeightGramme = candyWeightGramme;
    }

    @Override
    public String getName() {
        return candyName;
    }

    @Override
    public double getWeight() {
        return candyWeightGramme;
    }

    @Override
    public String toString() {
        return candyName + ": " + candyWeightGramme + " grams";
    }
}

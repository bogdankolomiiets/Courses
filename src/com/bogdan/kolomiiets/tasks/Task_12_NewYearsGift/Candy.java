package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

public class Candy implements Candies {
    private final String candyName;
    private final double candyWeightGramme;

    public Candy(ConfectioneryCatalog candy) {
        this.candyName = candy.name();
        this.candyWeightGramme = candy.getWeight();
    }

    public String getCandyName() {
        return candyName;
    }

    @Override
    public String toString() {
        return candyName + ": " + candyWeightGramme;
    }

    @Override
    public double getWeight() {
        return candyWeightGramme;
    }
}

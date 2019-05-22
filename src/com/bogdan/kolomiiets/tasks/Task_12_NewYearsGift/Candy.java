package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import java.io.Serializable;

public class Candy implements Candies, Serializable {
    private final String candyName;
    private final double candyWeightGramme;

    public Candy(ConfectioneryCatalog candy) {
        this.candyName = candy.name();
        this.candyWeightGramme = candy.getWeight();
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

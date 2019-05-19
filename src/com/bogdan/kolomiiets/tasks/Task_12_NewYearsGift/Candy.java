package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

public class Candy implements Candies {
    private final CandiesName candyName;
    private final int candyWeight;

    public Candy(CandiesName candyName, int candyWeight) {
        this.candyName = candyName;
        this.candyWeight = candyWeight;
    }

    public String getCandyName() {
        return candyName.name();
    }

    public int getCandyWeight() {
        return candyWeight;
    }
}

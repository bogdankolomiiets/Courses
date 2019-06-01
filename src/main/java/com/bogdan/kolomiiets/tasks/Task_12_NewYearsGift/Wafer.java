package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

public class Wafer implements Wafers {
    private String waferName;
    private double waferWeightGramme;

    public Wafer(String waferName, double waferWeightGramme) {
        this.waferName = waferName;
        this.waferWeightGramme = waferWeightGramme;
    }

    @Override
    public String getName() {
        return waferName;
    }

    @Override
    public double getWeight() {
        return waferWeightGramme;
    }

    @Override
    public String toString() {
        return waferName + ": " + waferWeightGramme + " grams";
    }
}

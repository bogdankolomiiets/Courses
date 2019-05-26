package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

public class Wafer implements Wafers {
    private final String waferName;
    private final double waferWeightGramme;

    public Wafer(ConfectioneryCatalog wafer) {
        this.waferName = wafer.name();
        this.waferWeightGramme = wafer.getWeight();
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
        return waferName + ": " + waferWeightGramme + " grams ";
    }
}

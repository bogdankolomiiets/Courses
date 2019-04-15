package com.bogdan.kolomiiets.tasks.Task_08_Flowers;

public class Flower {
    private FlowersName flowerName;
    private int priceForPiece;
    private int count;

    public Flower(FlowersName flowerName, int priceForPiece, int count) {
        this.flowerName = flowerName;
        this.priceForPiece = priceForPiece;
        this.count = count;
    }

    public int getPriceForPiece() {
        return priceForPiece;
    }

    @Override
    public String toString() {
        return flowerName + "";
    }
}

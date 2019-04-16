package com.bogdan.kolomiiets.tasks.Task_08_Flowers;

import java.util.ArrayList;

public class Bouquet {
    private ArrayList<Flower> flowerBouquet = new ArrayList<>();
    private int flowerCount;

    public void setFlowerCount(int flowerCount) {
        this.flowerCount = flowerCount;
    }

    public int getFlowerCount() {
        return flowerCount;
    }

    public void addFlowerIntoBouquet(Flower flower) {
        this.flowerBouquet.add(flower);
    }

    //remove flower with min price from a bouquet
    public Flower removeFlower() {
        //find out flower with min price in flowerArrayList
        Flower flowerToRemove = null;
        if (flowerBouquet.size() > 0) {
            int price = flowerBouquet.get(0).getPriceForPiece();
            flowerToRemove = flowerBouquet.get(0);
            for (Flower f : flowerBouquet){
                flowerToRemove = f.getPriceForPiece() < price ? f : flowerToRemove;
            }

            //remove flower with minimal price
            this.flowerBouquet.remove(flowerToRemove);
            flowerCount--;
            System.out.println("REMOVED " + flowerToRemove);
        } else System.out.println("Nothing to remove");
        return flowerToRemove;
    }

    //find out bouquet price
    private int getBouquetPrice(){
        int sum = 0;
        for (Flower f : flowerBouquet){
            sum += f.getPriceForPiece();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Bouquet" + flowerBouquet +
                ",\nflowerCount = " + flowerCount +
                " bouquet price: " + getBouquetPrice() + "\n";
    }
}

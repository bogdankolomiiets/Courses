package com.bogdan.kolomiiets.tasks.Task_08_Flowers;

import java.util.ArrayList;
import java.util.Collections;

public class Bouquet {
    private ArrayList<Flower> flowerArrayList = new ArrayList<>();

    public void setFlowerCount(int flowerCount) {
        this.flowerCount = flowerCount;
    }

    private int flowerCount;

    public int getFlowerCount() {
        return flowerCount;
    }

    public void addFlowerToList(Flower flower) {
        this.flowerArrayList.add(flower);
    }

    public void removeFlower() {
        //find out flower with min price in flowerArrayList
        if (flowerArrayList.size() > 0) {
            int price = flowerArrayList.get(0).getPriceForPiece();
            Flower flowerToRemove = flowerArrayList.get(0);
            for (Flower f : flowerArrayList){
                flowerToRemove = f.getPriceForPiece() < price ? f : flowerToRemove;
            }

            //remove flower with minimal price
            this.flowerArrayList.remove(flowerToRemove);
            flowerCount--;
            //System.out.println("REMOVED " + flowerToRemove);
        } else System.out.println("Nothing to remove");
    }

    @Override
    public String toString() {
        return "Bouquet" + flowerArrayList +
                ",\nflowerCount = " + flowerCount;
    }
}

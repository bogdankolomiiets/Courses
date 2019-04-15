package com.bogdan.kolomiiets.tasks.Task_08_Flowers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlowerShop {
    private List<Flower> flowers = new ArrayList<>();

    public FlowerShop() {
        addFlowers();
    }

    private void addFlowers(){
        flowers.add(new Flower(FlowersName.ROSE, 40, 500));
        flowers.add(new Flower(FlowersName.CARNATION, 30, 100));
        flowers.add(new Flower(FlowersName.CHAMOMILE, 10, 300));
        flowers.add(new Flower(FlowersName.HYACINTH, 20, 30));
        flowers.add(new Flower(FlowersName.TULIP, 15, 500));
    }


    public void makeBouquet (int price){
        //Find out min price
        int minPrice = flowers.get(0).getPriceForPiece();
        for (Flower f : flowers){
            int iteratorPrice = f.getPriceForPiece();
            if (iteratorPrice < minPrice){
                minPrice = iteratorPrice;
            }
        }

        //try make bouquets
        Bouquet bouquet = new Bouquet();
        while (price >= minPrice) {
            Flower flower = flowers.get((int) (Math.random() * flowers.size()));
            if (flower.getPriceForPiece() <= price) {
                bouquet.addFlowerToList(flower);
                price -= flower.getPriceForPiece();
                bouquet.setFlowerCount(bouquet.getFlowerCount() + 1);
            }
        }
        //check count
        if (bouquet.getFlowerCount() % 2 == 0){
            bouquet.removeFlower();
        }
        System.out.println(bouquet);
    }
}


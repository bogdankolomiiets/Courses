package com.bogdan.kolomiiets.tasks.Task_08_Flowers;

import java.util.*;

public class FlowerShop {
    private List<Flower> flowers = new ArrayList<>();

    public FlowerShop() {
        addFlowers();
    }

    private void addFlowers(){
        flowers.add(new Flower(FlowersName.ROSE, 30, 500));
        flowers.add(new Flower(FlowersName.CARNATION, 25, 100));
        flowers.add(new Flower(FlowersName.CHAMOMILE, 5, 300));
        flowers.add(new Flower(FlowersName.HYACINTH, 20, 30));
        flowers.add(new Flower(FlowersName.TULIP, 10, 500));

        //sort array by max price
        flowers.sort(new CompareFlower());
    }


    protected void makeBouquet (int moneyCount) {
        //Find out min price
        int minPrice = getMinPrice();
        //try make bouquets
        Bouquet bouquet = new Bouquet();

        again: while (moneyCount >= minPrice) {
           for (Flower f : flowers) {
                if (moneyCount >= f.getPriceForPiece()) {
                    bouquet.addFlowerIntoBouquet(f);
                    f.setCount(f.getCount() - 1);
                    moneyCount -= f.getPriceForPiece();
                    bouquet.setFlowerCount(bouquet.getFlowerCount() + 1);

                }

            }
           if (moneyCount >= minPrice) continue again;

            /*check flowers count into bouquet
             * if flower was removed from bouquet
             * increase moneyCount on the price of removed flower*/
            Flower removedFlower = checkFlowersCount(bouquet);
            if (removedFlower != (null) && removedFlower.getPriceForPiece() > minPrice) {
                moneyCount += removedFlower.getPriceForPiece();
                flowers.remove(removedFlower);
            }
        }
        System.out.println(bouquet);
    }

    private int getMinPrice(){
        return flowers.get(flowers.size() - 1).getPriceForPiece();
    }

    private Flower checkFlowersCount(Bouquet bouquet){
        if (bouquet.getFlowerCount() % 2 == 0){
            Flower removedFlower = bouquet.removeFlower();
            return removedFlower;
        } else return null;
    }
}


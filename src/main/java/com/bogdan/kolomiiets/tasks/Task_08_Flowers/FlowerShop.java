package com.bogdan.kolomiiets.tasks.Task_08_Flowers;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {
    protected ArrayList<Flower> flowers = new ArrayList<>();

    public FlowerShop() {
        addFlowers(new Flower(FlowersName.ROSE, 30, 500));
        addFlowers(new Flower(FlowersName.CHAMOMILE, 5, 300));
        addFlowers(new Flower(FlowersName.CARNATION, 25, 100));
        addFlowers(new Flower(FlowersName.HYACINTH, 20, 30));
        addFlowers(new Flower(FlowersName.TULIP, 10, 500));
    }

    protected void addFlowers(Flower...flower){
        for (Flower f : flower) {
            if (f.getPriceForPiece() > 0 && f.getCount() > 0) {
                flowers.add(f);
            }
        }

        //sort array by max price
        flowers.sort(new CompareFlower());
    }


    protected void makeBouquet (int moneyCount) {
        //Find out min price
        int minPrice = getMinPrice();

        if (moneyCount >= minPrice) {
            //make copy of flowers array
            List<Flower> tempList = (ArrayList<Flower>) flowers.clone();


            int tempMoneyCount;
            //reserved bouquet variable
            Bouquet bouquet;

            //try make bouquets
            //it's loop for different variant of bouquets
            while (tempList.size() > 2) {
                bouquet = new Bouquet();
                tempMoneyCount = moneyCount;

                again:
                //it's loop while we have money
                while (tempMoneyCount >= minPrice) {
                    for (Flower f : tempList) {
                        if (tempMoneyCount >= f.getPriceForPiece()) {
                            bouquet.addFlowerIntoBouquet(f);
                            f.setCount(f.getCount() - 1);
                            tempMoneyCount -= f.getPriceForPiece();
                            bouquet.setFlowerCount(bouquet.getFlowerCount() + 1);

                        }

                    }
                /*if we have bought a flower with a minimum price
                and we have a money for the same flower, then we buy it again.
                After we check the flowers count*/
                    if (tempMoneyCount >= minPrice) continue again;

                    /*check flowers count into bouquet
                     * if flower was removed from bouquet
                     * increase moneyCount on the price of removed flower*/
                    Flower removedFlower = checkFlowersCount(bouquet);
                    if (removedFlower != (null) && removedFlower.getPriceForPiece() > minPrice) {
                        tempMoneyCount += removedFlower.getPriceForPiece();
                        tempList.remove(removedFlower);
                    }
                }
                System.out.println(bouquet);
                tempList.remove(0);
            }
        } else throw new IllegalArgumentException();
    }

    protected int getMinPrice(){
        //getting last index because arrayList flowers is sorted
        return flowers.get(flowers.size() - 1).getPriceForPiece();
    }

    protected Flower checkFlowersCount(Bouquet bouquet){
        if (bouquet != null && bouquet.getFlowerCount() % 2 == 0){
            Flower removedFlower = bouquet.removeFlower();
            return removedFlower;
        } else return null;
    }
}


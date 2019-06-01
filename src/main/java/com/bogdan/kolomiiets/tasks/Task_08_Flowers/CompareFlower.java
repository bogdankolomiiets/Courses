package com.bogdan.kolomiiets.tasks.Task_08_Flowers;

import java.util.Comparator;

public class CompareFlower implements Comparator<Flower> {

    @Override
    public int compare(Flower flower1, Flower flower2) {
        return flower2.getPriceForPiece() - flower1.getPriceForPiece();
    }
}

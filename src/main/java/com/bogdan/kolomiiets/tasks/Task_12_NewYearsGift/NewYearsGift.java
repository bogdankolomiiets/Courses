package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewYearsGift implements Serializable {
    private static Logger LOGGER = Logger.getLogger(NewYearsGift.class);
    private Map<Confectionery, Integer> newYearsGift = new HashMap<>();
    private double newYearsGiftWeight;

    public boolean putToGift(List<Confectionery> confectionery, int countEachKindOfConfectionery) {
        if (countEachKindOfConfectionery > 0 && confectionery != null) {
            if (confectionery.size() > 0) {
                confectionery.forEach(c -> newYearsGift.put(c, countEachKindOfConfectionery));
                LOGGER.info("New gift created successful.");
                //calculation new years gift weight
                calculateWeight();
                return true;
            } else {
                //put warning to log
                LOGGER.warn("Confectionery factory didn't made a product. confectionery.size() = " + confectionery.size());
                return false;
            }
        } else {
            //put warning to log
            LOGGER.warn("confectionery not added to NewYearsGift. Cause: countEachKindOfCandy = " +
                                countEachKindOfConfectionery + " confectionery = " + confectionery);
            return false;
        }
    }

    public Map<Confectionery, Integer> getNewYearsGift() {
        return newYearsGift;
    }

    public void setNewYearsGift(Map<Confectionery, Integer> newYearsGift) {
        this.newYearsGift = newYearsGift;
    }

    private void calculateWeight(){
        newYearsGift.forEach((key, value) -> newYearsGiftWeight += key.getWeight() * value);
    }

    @Override
    public String toString() {
        return newYearsGift + " Weight = " + newYearsGiftWeight + " grammes";
    }

    public boolean getConfectionery(String productName) {
        String result = "New years gift don't contains candy with name " + productName;
        Confectionery confectionery = newYearsGift.keySet()
                .stream()
                .filter(name -> name.getName().equalsIgnoreCase(productName))
                .findAny().orElse(null);

        if (confectionery == null) {
            System.out.println("New years gift don't contains confectionery with name \"" + productName + "\"");
            return false;
        } else {
            System.out.println("Found " + confectionery.toString());
            return true;
        }
    }

    public boolean getConfectionery(double productWeight) {
        Confectionery confectionery = newYearsGift.keySet()
                .stream()
                .filter(weight -> weight.getWeight() == productWeight)
                .findAny().orElse(null);

        if (confectionery == null) {
            System.out.println("New years gift don't contains confectionery with weight " + productWeight);
            return false;
        } else {
            System.out.println("Found " + confectionery.toString());
            return true;
        }
    }
}

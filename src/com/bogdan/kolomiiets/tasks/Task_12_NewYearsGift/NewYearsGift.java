package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class NewYearsGift {
    private static Logger LOGGER = Logger.getLogger(NewYearsGift.class);
    private Map<Confectionery, Integer> newYearsGift = new HashMap<>();
    private double newYearsGiftWeight;

    public boolean putToGift(Map<Confectionery, Integer> confectionery, int countEachKindOfConfectionery) {
        if (countEachKindOfConfectionery > 0 && confectionery != null) {
            if (confectionery.size() > 0) {
                for (Map.Entry<Confectionery, Integer> entry : confectionery.entrySet()) {
                    newYearsGift.put(entry.getKey(), countEachKindOfConfectionery);
                }
                //put info to log
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
            LOGGER.warn("confectionery not added to NewYearsGift. Cause: countEachKindOfCandy = " + countEachKindOfConfectionery + " confectionery = " + confectionery);
            return false;
        }
    }

    public Map<Confectionery, Integer> getNewYearsGift() {
        return newYearsGift;
    }

    private void calculateWeight(){
        newYearsGift.forEach((key, value) -> newYearsGiftWeight += key.getWeight() * value);
    }

    public double getNewYearsGiftWeight() {
        return newYearsGiftWeight;
    }
}

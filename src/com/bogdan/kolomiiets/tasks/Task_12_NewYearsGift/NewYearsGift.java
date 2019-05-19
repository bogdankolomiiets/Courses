package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

public class NewYearsGift {
    private Map<Candies, Integer> newYearsGift = new HashMap<>();
    private final Logger logger = Logger.getLogger(this.getClass());

    public boolean addToNewYearsGift(Candies candy, int count) {
        if (candy != null && count > 0) {
            if (newYearsGift.containsKey(candy)) {
                newYearsGift.put(candy, newYearsGift.get(candy).intValue() + count);
            } else {
                newYearsGift.put(candy, count);
            }
            logger.info("");
            return true;
        } else {
            logger.warn("");
            return false;
        }
    }
}

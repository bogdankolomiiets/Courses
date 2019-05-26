package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;
import java.io.Serializable;
import java.util.*;

public class GiftSorter implements Serializable {
    private static Logger LOGGER = Logger.getLogger(GiftSorter.class);
    public static final int BY_NAME = 1;
    public static final int BY_WEIGHT = 2;


    public boolean sortGift(NewYearsGift newYearsGift, int sortBy) {
        if (newYearsGift != null) {
            try {
                Map<Confectionery, Integer> tempMap;
                switch (sortBy) {
                    case BY_NAME:
                        tempMap = new TreeMap<>((Comparator<Confectionery> & Serializable)
                                (c1, c2) -> c1.getName().compareTo(c2.getName()));
                        break;
                    case BY_WEIGHT:
                        tempMap = new TreeMap<>((Comparator<Confectionery> & Serializable)
                                (o1, o2) -> o1.getWeight() < o2.getWeight() ? -1 : o1.getWeight() == o2.getWeight() ? o1.getName().compareTo(o2.getName()) : 1);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                newYearsGift.getNewYearsGift().forEach(tempMap::put);
                newYearsGift.setNewYearsGift(tempMap);
                LOGGER.info("New years gift sorted successful.");
                return true;
            } catch (IllegalArgumentException ex) {
                LOGGER.warn("New years gift don't sorted.");
                return false;
            }
        } else {
            LOGGER.warn("New years gift don't sorted. Cause: newYearsGift = " + newYearsGift);
            return false;
        }
    }
}
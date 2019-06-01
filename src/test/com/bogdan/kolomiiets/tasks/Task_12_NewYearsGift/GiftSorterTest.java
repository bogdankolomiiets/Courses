package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;

public class GiftSorterTest extends Assert {
    private static GiftSorter giftSorter;
    private static NewYearsGift newYearsGift;

    @BeforeClass
    public static void init(){
        giftSorter = new GiftSorter();
        newYearsGift = new NewYearsGift();
        Confectionery[] confectioneries = new Confectionery[5];
        for (int i = 0; i < 5; i++){
            confectioneries[i] = new Candy("candy" + (i + 1), i + 1);
        }
        newYearsGift.putToGift(Arrays.asList(confectioneries), 2);
    }

    @Test
    public void sortGiftNullPointer(){
        assertFalse(giftSorter.sortGift(null, GiftSorter.BY_NAME));
    }

    @Test
    public void sortGiftTest(){
        assertTrue(giftSorter.sortGift(newYearsGift, GiftSorter.BY_WEIGHT));
    }

    @Test
    public void sortGiftTest2(){
        assertTrue(giftSorter.sortGift(newYearsGift, -500));
    }
}

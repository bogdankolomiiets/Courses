package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class NewYearsGiftTest extends Assert {
    private static NewYearsGift newYearsGift = new NewYearsGift();
    private static Confectionery[] confectioneries;

    @BeforeClass
    public static void init(){
        confectioneries = new Confectionery[5];
        for (int i = 0; i < 5; i++){
            confectioneries[i] = new Candy("candy" + (i + 1), i + 1);
        }
    }

    @Test
    public void newYearsGiftTestNullPointerAndMinus(){
        assertFalse(newYearsGift.putToGift(null, 2));
        assertFalse(newYearsGift.putToGift(Arrays.asList(confectioneries), -50));
    }

    @Test
    public void newYearsGiftTest(){
        newYearsGift.putToGift(Arrays.asList(confectioneries), 5);
        assertTrue(newYearsGift.getNewYearsGift().containsValue(5));
        assertTrue(newYearsGift.getNewYearsGift().size() == 5);
    }

    @Test
    public void newYearsGiftGetConfectioneryTest(){
        newYearsGift.putToGift(Arrays.asList(confectioneries), 5);
        assertTrue(newYearsGift.getConfectionery("candy1"));
        assertTrue(newYearsGift.getConfectionery(4));
        assertFalse(newYearsGift.getConfectionery("ggg"));
        assertFalse(newYearsGift.getConfectionery(6));
    }
}

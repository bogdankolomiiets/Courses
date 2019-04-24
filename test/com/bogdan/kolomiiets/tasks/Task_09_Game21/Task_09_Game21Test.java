package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Task_09_Game21Test extends Assert {
    public static CardDeck deck;

    @BeforeClass
    public static void initCardDeck(){
        deck = new CardDeck();
    }

    @Test(timeout = 1000)
    public void mixDeckTest(){
        deck.mixDeck(1000);
    }

    @Test
    public void getRandomIntInRangeInclusiveTest(){
        int i = deck.getRandomIntInRangeInclusive(5, 5);
        assertEquals(5 , i);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRandomIntInRangeInclusiveTest2(){
        deck.getRandomIntInRangeInclusive(10, 0);
    }

    @AfterClass
    public static void destroyCardDeck(){
        deck = null;
    }
}

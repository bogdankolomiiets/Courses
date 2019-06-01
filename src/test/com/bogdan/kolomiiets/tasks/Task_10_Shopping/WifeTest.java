package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WifeTest extends Assert {
    public static Wife wife;

    @BeforeClass
    public static void initWife(){
        wife = new Wife();
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointAll(){
        wife.displayAllProductsList(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointAvailable(){
        wife.displayAvailableProducts(null);
    }

    @AfterClass
    public static void  destroyWife(){
        wife = null;
    }
}

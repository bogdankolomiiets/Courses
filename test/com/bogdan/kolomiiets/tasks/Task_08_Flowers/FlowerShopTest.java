package com.bogdan.kolomiiets.tasks.Task_08_Flowers;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FlowerShopTest extends Assert {
    public static FlowerShop flowerShop;

    @BeforeClass
    public static void initFlowerShop(){
    flowerShop = new FlowerShop();
    }

    @Test(timeout = 100)
    public void testFlowerShop(){
        flowerShop.makeBouquet(10000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFlowerShop2(){
        flowerShop.makeBouquet(-50);
    }

    @Test
    public void addFlowersTest(){
        flowerShop.flowers.clear();
        flowerShop.addFlowers(new Flower(FlowersName.CHAMOMILE, -15, 50));
        flowerShop.addFlowers(new Flower(FlowersName.CHAMOMILE, 1, 50));
        flowerShop.addFlowers(new Flower(FlowersName.CARNATION, 20, -100));
        assertTrue(flowerShop.flowers.size() == 1);
    }

    @Test
    public void minPriceTest(){
        assertTrue(flowerShop.getMinPrice() == 1);
    }

    @Test
    public void checkFlowersCountTest(){
        assertNull(flowerShop.checkFlowersCount(null));
    }

    @AfterClass
    public static void destroyFlowerShop(){
        flowerShop = null;
    }
}

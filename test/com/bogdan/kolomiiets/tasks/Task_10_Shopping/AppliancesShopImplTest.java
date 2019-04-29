package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppliancesShopImplTest extends Assert {
    public static AppliancesShopImpl appliancesShop;

    @BeforeClass
    public static void initAppliancesShopImpl(){
        appliancesShop = new AppliancesShopImpl();
    }

    @Test(expected = NullPointerException.class)
    public void AppliancesShopTestNull(){
        appliancesShop.addProduct(null);
    }

    @Test
    public void AppliancesShopTestSize(){
        assertTrue(appliancesShop.getProductList().size() == 0);
        appliancesShop.addProduct(new Product(ProductsName.BEEF, 20));
        assertTrue(appliancesShop.getProductList().size() == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AppliancesShopTestNegativePrice(){
        appliancesShop.addProduct(new Product(ProductsName.BEEF, -5));
    }

    @AfterClass
    public static void destroyAppliancesShopImpl(){
        appliancesShop = null;
    }
}

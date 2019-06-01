package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GroceryShopImplTest extends Assert {
    public static GroceryShopImpl groceryShop;

    @BeforeClass
    public static void initAppliancesShopImpl(){
        groceryShop = new GroceryShopImpl();
    }

    @Test(expected = NullPointerException.class)
    public void GroceryShopTestNull(){
        groceryShop.addProduct(null);
    }

    @Test
    public void GroceryShopTestSize(){
        assertTrue(groceryShop.getProductList().size() == 0);
        groceryShop.addProduct(new Product(ProductsName.BEEF, 20));
        assertTrue(groceryShop.getProductList().size() == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void GroceryShopTestNegativePrice(){
        groceryShop.addProduct(new Product(ProductsName.BEEF, -5));
    }

    @AfterClass
    public static void destroyAppliancesShopImpl(){
        groceryShop = null;
    }
}

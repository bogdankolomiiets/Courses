package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest extends Assert {

    @Test(expected = IllegalArgumentException.class)
    public void testZeroPrice(){
        Product product = new Product(ProductsName.CAMERA, 0);
        System.out.println(product);
    }
}

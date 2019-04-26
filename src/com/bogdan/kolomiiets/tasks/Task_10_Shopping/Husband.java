package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import java.util.List;

public class Husband implements ShoppingList {
    private List<ProductsName> productsList;

    @Override
    public void takeProductsList(List<ProductsName> productsList) {
        this.productsList = productsList;
    }

    @Override
    public List<ProductsName> getProductsList() {
        return productsList;
    }
}

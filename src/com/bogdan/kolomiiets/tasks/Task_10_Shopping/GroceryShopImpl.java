package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import java.util.ArrayList;
import java.util.List;

public class GroceryShopImpl implements Shops {
    private List<Product> groceryProductsList = new ArrayList<>();

    @Override
    public List<Product> getGoodsList() {
        return groceryProductsList;
    }

    @Override
    public void addGoods(Product product) {
        if (product != null) {
            groceryProductsList.add(product);
        } else throw new NullPointerException();
    }
}

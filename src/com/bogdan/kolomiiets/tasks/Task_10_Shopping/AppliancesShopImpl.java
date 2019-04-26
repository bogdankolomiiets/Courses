package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import java.util.ArrayList;
import java.util.List;

public class AppliancesShopImpl implements Shops {
    private List<Product> appliancesProductsList = new ArrayList<>();

    @Override
    public List<Product> getGoodsList() {
        return appliancesProductsList;
    }

    @Override
    public void addGoods(Product product) {
        if (product != null) {
            appliancesProductsList.add(product);
        } else throw new NullPointerException();    }
}

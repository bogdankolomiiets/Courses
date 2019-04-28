package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Shops {
    Set<Shops> shops = new HashSet<>();
    List<Product> getProductList();
    void addProduct(Product product);
}

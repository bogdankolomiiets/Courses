package com.bogdan.kolomiiets.tasks.Task_10_Shopping;


import java.util.List;

public interface ShoppingList {
    void takeProductsList(List<ProductsName> productsList);
    List<ProductsName> getProductsList();
}

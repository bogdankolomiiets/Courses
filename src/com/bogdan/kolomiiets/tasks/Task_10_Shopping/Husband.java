package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Husband {
    private List<ProductsName> productsListFromWife;
    private Map<ProductsName, Double> allProductsList;

    public void takeProductsList(List<ProductsName> productsListFromWife) {
        this.productsListFromWife = productsListFromWife;
    }

    protected Map<ProductsName, Double> getAllProductsList(){
        allProductsList = new HashMap<>();
        findOutAllProductsList();
        return allProductsList;
    }

    protected Map<ProductsName, Double> getAvailableProductsList(){
        Map<ProductsName, Double> tempSet = new HashMap<>();
        for (ProductsName name : productsListFromWife){
            if (allProductsList.containsKey(name)){
                tempSet.put(name, allProductsList.get(name));
            }
        }
        return tempSet;
    }

    private void findOutAllProductsList(){
        for (Shops s : Shops.shops){
            for (Product p : s.getProductList())
            allProductsList.put(p.getName(), p.getPrice());
        }
    }
}

package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import java.util.*;

public class Wife {
    private List<ProductsName> productsList;

    public List<ProductsName> getProductsList(){
        productsList = new ArrayList<>();
        writeProductsList();
        displayProductListFromWife();
        return productsList;
    }

    /*wife is writing products list random
    * if randInt = 0 then wife goes to the next product
    * if randInt = 1 - wife needs this item*/
    private void writeProductsList(){
        Random random = new Random(System.nanoTime());
        for (ProductsName productsName : ProductsName.values()){
            int randInt = random.nextInt(2);
            if (randInt == 1){
                productsList.add(productsName);
            }
        }
    }

    public void displayProductListFromWife(){
        System.out.println("Wife wants to buy");
        for (ProductsName n : productsList){
            System.out.println(n);
        }
    }

    public void displayAllProductsList(Map<ProductsName, Double> products){
        if (products != null) {
            System.out.println("\nTotal list:");
            for (Map.Entry e : products.entrySet()){
                System.out.println(e.getKey() + " = " + e.getValue());
            }
        } else System.out.println("List does not exist!!!");
    }

    public void displayAvailableProducts(Map<ProductsName, Double> products) {
        if (products != null) {
            double totalPrice = 0;
            System.out.println("\nBought:");
            for (Map.Entry e : products.entrySet()) {
                System.out.println(e.getKey() + " = " + e.getValue());
                totalPrice += (double) e.getValue();
            }
            System.out.println("Total price = " + totalPrice);
        } else System.out.println("\nList does not exist!!!");
    }
}

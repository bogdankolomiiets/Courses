package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
            //generate int value between 0 and 1
            int randInt = random.nextInt(2);
            if (randInt == 1){
                productsList.add(productsName);
            }
        }
    }

    //display product list which wife written
    public void displayProductListFromWife(){
        System.out.println("Wife wants to buy");
        for (ProductsName n : productsList){
            System.out.println(n);
        }
    }

    public void displayAllProductsList(Map<ProductsName, Double> products){
        if (products != null) {
            if (products.size() == 0) {
                System.out.println("List is empty!!!");
            } else {
                System.out.println("\nTotal list:");
                for (Map.Entry e : products.entrySet()) {
                    System.out.println(e.getKey() + " = " + new DecimalFormat("0.##").format(e.getValue()));
                }
            }
        } else throw new NullPointerException("List does not exist!!!");
    }

    public void displayAvailableProducts(Map<ProductsName, Double> products) {
        if (products != null) {
            if (products.size() == 0) {
                System.out.println("List is empty!!!");
            } else {
                double totalPrice = 0;
                System.out.println("\nBought:");
                for (Map.Entry e : products.entrySet()) {
                    System.out.println(e.getKey() + " = " + new DecimalFormat("0.##").format(e.getValue()));
                    totalPrice += (double) e.getValue();
                }
                System.out.println("Total price = " + new DecimalFormat("0.00").format(totalPrice));
            }
        } else throw new NullPointerException("\nList does not exist!!!");
    }
}

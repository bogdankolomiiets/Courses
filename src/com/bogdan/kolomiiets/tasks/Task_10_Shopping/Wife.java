package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wife implements ShoppingList {
    private List<ProductsName> productsList;


    public List<ProductsName> getProductsList(){
        productsList = new ArrayList<>();
        writeProductsList();
        displayList();
        return productsList;
    }

    @Override
    public void takeProductsList(List<ProductsName> productsList) {

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

    private void displayList(){
        for (ProductsName n : productsList){
            System.out.println(n);
        }
        System.out.println("Total: " + productsList.size());
    }
}

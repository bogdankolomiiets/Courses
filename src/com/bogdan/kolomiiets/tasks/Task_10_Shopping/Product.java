package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

public class Product {
    private ProductsName name;
    private double price;

    public Product(ProductsName name, double price) {
        this.name = name;
        if (price > 0){
            this.price = price;
        } else throw new IllegalArgumentException("Price less then 0");
    }

    public ProductsName getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

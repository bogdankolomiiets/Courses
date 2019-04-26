package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

public class Product {
    private ProductsName name;
    private double price;

    public Product(ProductsName name, double price) {
        this.name = name;
        this.price = price;
    }

    public ProductsName getName() {
        return name;
    }

    public void setName(ProductsName name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

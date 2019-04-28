package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

public class Main {
    public static void main(String[] args) {
        //Create object
        Wife wife = new Wife();
        Husband husband = new Husband();

        fillShops();

        //Husband takes a list from wife
        husband.takeProductsList(wife.getProductsList());

        //Wife displays a list that was returned from husband
        wife.displayAllProductsList(husband.getAllProductsList());
        wife.displayAvailableProducts(husband.getAvailableProductsList());
    }

    //fill shops
    private static void fillShops(){
        Shops shop = new GroceryShopImpl();
        Shops.shops.add(shop);
        shop.addProduct(new Product(ProductsName.BEEF, 120.50));
        shop.addProduct(new Product(ProductsName.CHICKEN, 99.95));
        shop.addProduct(new Product(ProductsName.CUCUMBER, 33.10));
        shop.addProduct(new Product(ProductsName.ONION, 27.50));
        shop.addProduct(new Product(ProductsName.POTATO, 10));

        shop = new AppliancesShopImpl();
        Shops.shops.add(shop);
        shop.addProduct(new Product(ProductsName.CAMERA, 3000));
        shop.addProduct(new Product(ProductsName.TV, 8000));
        shop.addProduct(new Product(ProductsName.PHONE, 7000));
        shop.addProduct(new Product(ProductsName.TABLET, 4000));
    }
}

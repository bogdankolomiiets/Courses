package com.bogdan.kolomiiets.tasks.Task_10_Shopping;

public class Main {
    public static void main(String[] args) {
        Wife wife = new Wife();
        Husband husband = new Husband();
        fillShops();
        husband.takeProductsList(wife.getProductsList());
        ///
        wife.takeProductsList(husband.getProductsList());
    }

    private static void fillShops(){
        Shops shops = new GroceryShopImpl();
        shops.addGoods(new Product(ProductsName.BEEF, 120.50));
        shops.addGoods(new Product(ProductsName.CHICKEN, 99.95));
        shops.addGoods(new Product(ProductsName.CUCUMBER, 33.10));
        shops.addGoods(new Product(ProductsName.ONION, 27.50));
        shops.addGoods(new Product(ProductsName.POTATO, 10));

        shops = new AppliancesShopImpl();
        shops.addGoods(new Product(ProductsName.CAMERA, 10200));
        shops.addGoods(new Product(ProductsName.NOTEBOOK, 29999));
        shops.addGoods(new Product(ProductsName.PHONE, 7000));
        shops.addGoods(new Product(ProductsName.TABLET, 4000));
    }
}

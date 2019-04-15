package com.bogdan.kolomiiets.tasks.Task_07_WineCatalog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        wineInitialise();
    }

    private static void wineInitialise(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        //initial catalog
        Catalog catalog = new Catalog();

        //create wine objects
        Wine wine1 = new Wine(WineName.Gewürztraminer.name(), "Germany", new Date(2000, 10, 5));
        Wine wine2 = new Wine(WineName.Chardonnay.name(), "France", new Date(2000, 9, 18));
        Wine wine3 = new Wine(WineName.Merlot.name(), "Australia", new Date(2005, 11, 13));
        Wine wine4 = new Wine(WineName.Syrah.name(), "California", new Date(2016, 10, 8));

        //add wine into catalog
        catalog.addWineToCatalog(wine1, wine2, wine3, wine4);

        //get expire year
        catalog.expireDate(wine1, wine2, wine3, wine4);

        //print catalog
        catalog.printCatalog();
    }
}

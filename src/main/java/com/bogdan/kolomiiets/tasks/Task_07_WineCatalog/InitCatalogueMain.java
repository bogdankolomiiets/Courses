package com.bogdan.kolomiiets.tasks.Task_07_WineCatalog;

import java.time.DateTimeException;
import java.util.Calendar;

public class InitCatalogueMain {

    public static void main(String[] args) {
        InitCatalogueMain initCatalogue = new InitCatalogueMain();
        initCatalogue.wineInitialise();
    }

    private void wineInitialise(){
        //initial catalog
        Catalog catalog = new Catalog();

        //create wine objects
        Wine wine1 = new Wine(WineName.Gewürztraminer, "Germany", getCalendar(2000, 11, 15));
        Wine wine2 = new Wine(WineName.Chardonnay, "France", getCalendar(2000, 8, 18));
        Wine wine3 = new Wine(WineName.Merlot, "Australia", getCalendar(2005, 11, 13));
        Wine wine4 = new Wine(WineName.Syrah, "California", getCalendar(2016, 10, 8));

        //add wine into catalog
        catalog.addWineToCatalog(wine1, wine2, wine3, wine4);

        //print date of manufacture
        catalog.printProductionInfo();

        //get expire year
        catalog.expireDate(wine1, wine2, wine3, wine4);

        //print catalog
        catalog.printCatalog();

    }

    public static Calendar getCalendar(int year, int month, int day){
        if (month <= 12 && day < 32) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            return calendar;
        }
        else throw new DateTimeException("month: " + month + " day: " + day);
    }
}

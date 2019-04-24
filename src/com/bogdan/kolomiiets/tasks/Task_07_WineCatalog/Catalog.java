package com.bogdan.kolomiiets.tasks.Task_07_WineCatalog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Catalog {
    protected List<Wine> catalogue = new ArrayList();

    protected void addWineToCatalog(Wine...wine) {
        for (Wine w : wine) {
            catalogue.add(w);
        }
    }

    protected void printProductionInfo(){
        System.out.println("Displaying production information...");
        for (Wine w : catalogue) {
            int year = w.getBottlingDate().get(Calendar.YEAR);
            System.out.println("For wine " + w.getWineName() + " date of manufacture: " + year);
        }
    }

    protected void expireDate(Wine...wine){
        System.out.println("\nDisplaying expire information...");
        for (Wine w : wine) {
            int year = w.getExpire();
            System.out.println("For wine " + w.getWineName() + " expire year is: " + year);
        }
    }

    protected void printCatalog(){
        System.out.println("\nPrint wine catalog...");
        for (Wine w : catalogue) {
            System.out.println(w);
        }
    }

}

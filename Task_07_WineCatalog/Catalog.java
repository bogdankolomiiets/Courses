package com.bogdan.kolomiiets.tasks.Task_07_WineCatalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Wine> catalogue = new ArrayList();

    public void addWineToCatalog(Wine...wine) {
        for (Wine w : wine) {
            catalogue.add(w);
        }
    }

    public void expireDate(Wine...wine){
        for (Wine w : wine) {
            int year = w.getExpire();
            System.out.println("For wine " + w.getWineName() + " expire year is: " + year);
        }
    }

    public void printCatalog(){
        System.out.println("\nPrint wine catalog...");
        for (Wine w : catalogue) {
            System.out.println(w);
        }
    }

}

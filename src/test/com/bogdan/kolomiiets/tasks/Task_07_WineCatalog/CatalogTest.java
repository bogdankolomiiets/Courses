package com.bogdan.kolomiiets.tasks.Task_07_WineCatalog;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.DateTimeException;
import java.util.Calendar;

public class CatalogTest extends Assert {
    public static Catalog catalog;

    @BeforeClass
    public static void initWineCatalogue(){
        catalog = new Catalog();
    }

    @Test
    public void addWineToCatalogTest(){
        catalog.addWineToCatalog(new Wine(WineName.Chardonnay, "Italy", Calendar.getInstance()));
        catalog.addWineToCatalog(new Wine(WineName.Chardonnay, "Italy", Calendar.getInstance()));
        assertTrue(catalog.catalogue.size() == 2);
    }

    @Test(expected = DateTimeException.class)
    public void expireDateTest(){
        catalog.expireDate(new Wine(WineName.Merlot, "Italy", InitCatalogueMain.getCalendar(2000, 2000, 04)));
    }


    @AfterClass
    public static void destroyWineCatalogue(){
        catalog = null;
    }
}

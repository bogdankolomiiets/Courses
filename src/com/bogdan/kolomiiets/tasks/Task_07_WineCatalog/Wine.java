package com.bogdan.kolomiiets.tasks.Task_07_WineCatalog;

import java.util.Calendar;

public class Wine {
    private WineName wineName;
    private String originCountry;
    private Calendar bottlingDate;

    public Wine(WineName wineName, String originCountry, Calendar bottlingDate) {
        this.wineName = wineName;
        this.originCountry = originCountry;
        this.bottlingDate = bottlingDate;
    }

    public WineName getWineName() {
        return wineName;
    }

    public Calendar getBottlingDate() {
        return bottlingDate;
    }

    public int getExpire(){
        return this.getWineName().expire + bottlingDate.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return "wineName = '" + wineName + '\'' +
                ", originCountry = '" + originCountry + '\'' +
                ", bottlingDate = " + bottlingDate.get(Calendar.YEAR)  + "/"
                                    + bottlingDate.get(Calendar.MONTH) + "/"
                                    + bottlingDate.get(Calendar.DAY_OF_MONTH) +
                " expire year: " + getExpire();
    }
}

package com.bogdan.kolomiiets.tasks.Task_07_WineCatalog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Wine {
    private String wineName;
    private String originCountry;
    private Date bottlingDate;

    public Wine(String wineName, String originCountry, Date bottlingDate) {
        this.wineName = wineName;
        this.originCountry = originCountry;
        this.bottlingDate = bottlingDate;
    }

    public String getWineName() {
        return wineName;
    }

    public Date getBottlingDate() {
        return bottlingDate;
    }

    public int getExpire(){
        return WineName.valueOf(this.getWineName()).expire + this.getBottlingDate().getYear();
    }

    @Override
    public String toString() {
        return "wineName='" + wineName + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", bottlingDate=" + bottlingDate +
                " expire year: " + getExpire();
    }
}

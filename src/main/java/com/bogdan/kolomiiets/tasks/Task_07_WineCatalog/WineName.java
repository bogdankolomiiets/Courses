package com.bogdan.kolomiiets.tasks.Task_07_WineCatalog;

public enum WineName {
    Gewürztraminer(50),
    Chardonnay(50),
    Syrah(70),
    Merlot(55);

    public int expire;

    WineName(int expire) {
        this.expire = expire;
    }

    public int getExpire(){
        return expire;
    }
}

package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import java.util.Map;

public interface ConfectioneryFactory {
    void makeConfectionery(Confectionery confectionery, Integer kilo);
    Map<Confectionery, Integer> getConfectionery();
}

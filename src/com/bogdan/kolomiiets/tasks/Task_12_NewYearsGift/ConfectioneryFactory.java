package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import java.io.Serializable;
import java.util.Map;

public interface ConfectioneryFactory extends Serializable {
    void makeConfectionery();
    Map<Confectionery, Integer> getConfectionery();
}

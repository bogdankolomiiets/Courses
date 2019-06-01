package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import java.io.BufferedReader;
import java.util.List;

public interface ConfectioneryFactory {
    boolean makeConfectionery(BufferedReader reader);
    List<Confectionery> getConfectionery();
}

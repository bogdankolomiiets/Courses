package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.Comparator;

public class CompareGamers implements Comparator<Gamers> {

    @Override
    public int compare(Gamers o1, Gamers o2) {
        return o1.isBanker() ? -1 : 1;
    }
}

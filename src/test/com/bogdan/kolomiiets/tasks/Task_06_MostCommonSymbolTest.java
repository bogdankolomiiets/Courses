package com.bogdan.kolomiiets.tasks;

import org.junit.Assert;
import org.junit.Test;

public class Task_06_MostCommonSymbolTest extends Assert {
    @Test
    public void stringEmptyTest(){
        String s = Task_06_MostCommonSymbol.checkCommonSymbol("");
        assertSame("String empty", s);
    }

    @Test
    public void MostCommonTest(){
        String s = Task_06_MostCommonSymbol.checkCommonSymbol("@");
        assertSame('@', Task_06_MostCommonSymbol.symbol);
    }
}

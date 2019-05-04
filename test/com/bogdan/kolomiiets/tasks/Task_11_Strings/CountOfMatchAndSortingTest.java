package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountOfMatchAndSortingTest extends Assert {
    public static String[] listOfWords;
    public static List<String> textCollection;

    @BeforeClass
    public static void initCountOfMatchAndSorting(){
        listOfWords = new String[]{"no", "on", "no", "the"};
        textCollection = new ArrayList<>();
        textCollection.add("no");
        textCollection.add("on");
        textCollection.add("no");
        textCollection.add("the");
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerTest1(){
        CountOfMatchAndSorting.findOutMatchesCount(null, listOfWords);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerTest2(){
        CountOfMatchAndSorting.findOutMatchesCount(textCollection, null);
    }

    @Test()
    public void checkingMapSize(){
        Map<String, Integer> tempMap = CountOfMatchAndSorting.findOutMatchesCount(textCollection, listOfWords);
        assertTrue(tempMap.size() == 3);
    }

    @Test(expected = RuntimeException.class)
    public void checkingEmptyListOfWords(){
        CountOfMatchAndSorting.findOutMatchesCount(textCollection, new String[]{});
    }

    @Test()
    public void checkingSortMatchesCountMethod(){
        Map<String, Integer> tempMap = CountOfMatchAndSorting.findOutMatchesCount(textCollection, listOfWords);
        tempMap = CountOfMatchAndSorting.sortMatchesCount(tempMap);
        assertTrue(tempMap.get("no").intValue() == 2);
    }

    @AfterClass
    public static void destroyCountOfMatchAndSorting(){
        listOfWords = null;
        textCollection = null;
    }
}
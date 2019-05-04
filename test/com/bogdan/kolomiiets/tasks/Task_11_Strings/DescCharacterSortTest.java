package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class DescCharacterSortTest extends Assert {
    public static List<String> textCollection;

    @BeforeClass
    public static void initTextCollection(){
        textCollection = new ArrayList<>();
        String text = "the apple the onion that";

        for (String s : text.split(" ")){
            textCollection.add(s);
        }
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerTest(){
        DescCharacterSort.sortListByDescCharacter('t', null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgumentTest(){
        DescCharacterSort.sortListByDescCharacter('*', textCollection);
    }

    @Test
    public void sortListByDescCharacterTest(){
        List<String> stringList = DescCharacterSort.sortListByDescCharacter('t', textCollection);
        assertTrue(stringList.get(0).equals("that"));
        //testing big character
        stringList = DescCharacterSort.sortListByDescCharacter('T', textCollection);
        assertTrue(stringList.get(0).equals("that"));
    }

    @AfterClass
    public static void destroyTextCollection(){
        textCollection = null;
    }
}

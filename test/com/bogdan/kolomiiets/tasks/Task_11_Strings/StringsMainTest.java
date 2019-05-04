package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class StringsMainTest extends Assert {

    @Test(expected = NullPointerException.class)
    public void nullPointerTest(){
        FindPalindrome.getMaxLengthPalindrome(null);
    }

    @Test(expected = RuntimeException.class)
    public void emptyCollectionTest(){
        FindPalindrome.getMaxLengthPalindrome(new ArrayList<>());
    }

    @Test()
    public void getMaxLengthPalindromeTest(){
        List<String> textCollection = new ArrayList<>();
        textCollection.add("fof");
        textCollection.add("lol");
        textCollection.add("did");
        textCollection.add("diddid");
        textCollection.add("tooooot");

        String s = FindPalindrome.getMaxLengthPalindrome(textCollection);
        assertEquals("correct", "MAX length palindrome is: tooooot", s);
    }
}

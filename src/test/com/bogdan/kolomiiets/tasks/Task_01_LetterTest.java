package com.bogdan.kolomiiets.tasks;

import org.junit.*;

public class Task_01_LetterTest extends Assert {
    public static Task_01_Letter letter;

    @BeforeClass
    public static void initLetterClass(){
        letter = new Task_01_Letter();
    }

    @Test
    public void makeLetterTest(){
        letter.makeRandomLetter();
        int randIndex = letter.randIndex;
        assertTrue(randIndex >= 0 || randIndex <= letter.enAlphabet.length());
    }

    @AfterClass
    public static void destroyLetterClass(){
        letter = null;
    }
}

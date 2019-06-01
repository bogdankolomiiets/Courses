package com.bogdan.kolomiiets.tasks;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Task_02_PalindromeTest extends Assert {
    public static Task_02_Palindrome palindrome;

    @BeforeClass
    public static void initTask_02_Palindrome(){
        palindrome = new Task_02_Palindrome();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllBinPalindromeFromIntTest(){
        palindrome.getAllBinPalindromeFromInt(6, 5);
    }

    @AfterClass
    public static void destroyTask_02_Palindrome(){
        palindrome = null;
    }
}

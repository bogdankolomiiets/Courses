package com.bogdan.kolomiiets.tasks;

import org.junit.*;

public class Task_03_OddNumberTest extends Assert {
    public static Task_03_OddNumber oddNumber;

    @BeforeClass
    public static void initTask_03_OddNumber(){
        oddNumber = new Task_03_OddNumber();
    }

    @After
    public void destroyMaxOdd(){
        oddNumber.maxOdd = Integer.MIN_VALUE;
    }

    @Test
    public void showMaxOddTest(){
        oddNumber.showMaxOdd(new int[] {20, 41, 43});
        assertEquals(43, oddNumber.maxOdd);
    }

    @Test
    public void showMaxOddTest2(){
        oddNumber.showMaxOdd(new int[] {});
        assertEquals(Integer.MIN_VALUE, oddNumber.maxOdd);
    }

    @Test
    public void showMaxOddTest3(){
        oddNumber.showMaxOdd(new int[] {-1, -15, Integer.MIN_VALUE, -13, -20});
        assertEquals(-1, oddNumber.maxOdd);
    }

    @AfterClass
    public static void destroyTask_03_OddNumber(){
        oddNumber = null;
    }
}

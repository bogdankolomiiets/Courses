package com.bogdan.kolomiiets.tasks;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Task_04_IdenticalNumbersTest extends Assert {
    public static Task_04_IdenticalNumbers numbers;

    @BeforeClass
    public static void initTask_04_IdenticalNumbers(){
        numbers = new Task_04_IdenticalNumbers();
    }

    @Test
    public void checkIdenticalNumbersTest(){
        int[] arr1 = {};
        int[] arr2 = {};
        numbers.checkIdenticalNumbers(arr1, arr2);
        assertNotNull(numbers.identical);
    }

    @Test
    public void checkIdenticalNumbers2Test(){
        int[] arr1 = {5, 6, -5, 0};
        int[] arr2 = {5, 7, -5, 0};
        numbers.checkIdenticalNumbers(arr1, arr2);
        assertEquals(3, numbers.identical.size());
    }

    @Test
    public void checkIdenticalNumbers3Test(){
        int[] arr1 = {5, 6, -5, 00};
        int[] arr2 = {5, 7, -5, 000};
        numbers.checkIdenticalNumbers(arr1, arr2);
        assertEquals(3, numbers.identical.size());
    }

    @Test
    public void checkIdenticalNumbers4Test(){
        int[] arr1 = {8, 6, -5, 9};
        int[] arr2 = {1, 2, -4, 0};
        numbers.checkIdenticalNumbers(arr1, arr2);
        assertEquals(0, numbers.identical.size());
    }

    @AfterClass
    public static void destroyTask_04_IdenticalNumbers(){
        numbers = null;
    }
}

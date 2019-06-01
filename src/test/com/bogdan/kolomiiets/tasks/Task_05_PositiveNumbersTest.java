package com.bogdan.kolomiiets.tasks;

import org.junit.*;

public class Task_05_PositiveNumbersTest extends Assert {
    public static Task_05_PositiveNumbers numbers;

    @BeforeClass
    public static void initTask_05_PositiveNumbers(){
        numbers = new Task_05_PositiveNumbers();
    }

    @Test
    public void testNullArray(){
        assertNull(Task_05_PositiveNumbers.arrayA);
    }

    @After
    public void destroyArray(){
        Task_05_PositiveNumbers.arrayA = null;
    }

    @Test
    public void createAndFeelStartArrayTest(){
        numbers.createAndFeelStartArray(8, 8);
        assertNotNull(Task_05_PositiveNumbers.arrayA);
        assertTrue(Task_05_PositiveNumbers.arrayA.length == 8);
    }

    @Test
    public void createAndFeelStartZeroArrayTest(){
        numbers.createAndFeelStartArray(0, -10);
        assertNotNull(Task_05_PositiveNumbers.arrayA);
        assertTrue(Task_05_PositiveNumbers.arrayA.length == 10);
        assertFalse(Task_05_PositiveNumbers.arrayA.length == 0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void createPositiveArrayTest(){
        int[][] arr = new int[0][0];
        numbers.createPositiveArray(arr);
    }

    @Test(expected = NullPointerException.class)
    public void printArrayTest(){
        Task_05_PositiveNumbers.printArray(null);
    }

    @AfterClass
    public static void destroyTask_05_PositiveNumbers(){
        numbers = null;
    }
}

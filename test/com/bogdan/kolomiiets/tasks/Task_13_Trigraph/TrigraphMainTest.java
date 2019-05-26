package com.bogdan.kolomiiets.tasks.Task_13_Trigraph;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TrigraphMainTest extends Assert {
    public static Map<String, Integer> mapForTest = new HashMap<>();
    public File file = new File("TrigraphResultsTest.txt");
    public File sourceFile = new File("TrigraphSource.txt");

    @BeforeClass
    public static void init(){
        mapForTest.put("INT", 5);
        mapForTest.put("TOO", 1);
        mapForTest.put("ONE", 4);
        mapForTest.put("THE", 1);
        mapForTest.put("ARE", 2);
    }

    @Test
    public void saveResultsToFileAndDisplayTestNull() {
        TrigraphMain.saveResultsToFileAndDisplay(null, null);
        assertFalse("", false);
    }
    @Test
    public void saveResultsToFileAndDisplayTestNull2(){
        TrigraphMain.saveResultsToFileAndDisplay(mapForTest, null);
        assertFalse("", false);
    }

    @Test
    public void saveResultsToFileAndDisplayTestNotNull(){
        TrigraphMain.saveResultsToFileAndDisplay(mapForTest, file);
        assertTrue("", true);
    }

    @Test
    public void readFileAndPutToMapNull(){
        assertNull(TrigraphMain.readFileAndPutToMap(null));
    }

    @Test
    public void readFileAndPutToMapNotNull(){
        assertNotNull(TrigraphMain.readFileAndPutToMap(sourceFile));
    }
}

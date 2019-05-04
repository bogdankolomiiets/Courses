package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ReplaceWordsTest extends Assert {
    public static List<String> textCollection;

    @BeforeClass
    public static void initTextCollection(){
        textCollection = new ArrayList<>();
        String text = "All of the source code to this product is available under licenses" +
                    "which are both free and open source A URL identifying the specific source " +
                    "code used to create this copy can be found on the build configuration page " +
                    "and you can read instructions on how to download and build the code for yourself ";

        for (String s : text.split(" ")){
            textCollection.add(s);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointer(){
        ReplaceWords.replaceSpecificLengthWords(4, "NEW", null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointer2(){
        ReplaceWords.replaceSpecificLengthWords(4, null, textCollection);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWordLength(){
        ReplaceWords.replaceSpecificLengthWords(0, "NEW", textCollection);
    }

    @Test()
    public void testReplacementWord(){
        int sizeBefore = textCollection.size();
        textCollection = ReplaceWords.replaceSpecificLengthWords(4, "", textCollection);
        assertTrue(textCollection.size() == sizeBefore - 12);
    }

    @AfterClass
    public static void destroyTextCollection(){
        textCollection = null;
    }
}

package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {
    public static List<String> replaceSpecificLengthWords(int wordLength, String replacementWord, List<String> textCollection) {
        if (wordLength < 1) {
            throw new IllegalArgumentException("Word length less than 1");
        } else if (replacementWord != null && textCollection != null) {
            List<String> tempList = new ArrayList<>(textCollection);
            for (int i = textCollection.size() - 1; i > 0; i--) {
                if (textCollection.get(i).length() == wordLength) {
                    if (replacementWord.equals("")) {
                        tempList.remove(i);
                    } else {
                        tempList.set(i, replacementWord);
                    }
                }
            }
            return tempList;
        } else throw new NullPointerException();
    }

}

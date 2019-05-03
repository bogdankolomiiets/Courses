package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {
    public static List<String> replaceSpecificLengthWords(int wordLength, String replacementWord, List<String> textCollection) {
        if (wordLength < 1) {
            throw new IllegalArgumentException("Word length less than 1");
        } else if (replacementWord != null && textCollection != null) {
            List<String> tempList = new ArrayList<>(textCollection);
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).length() == wordLength) {
                    tempList.set(i, replacementWord);
                }
            }
            return tempList;
        } else throw new NullPointerException();
    }

}

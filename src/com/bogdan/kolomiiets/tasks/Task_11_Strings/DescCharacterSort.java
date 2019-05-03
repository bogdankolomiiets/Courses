package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class DescCharacterSort {
    private char charForChecking;

    public List<String> sortListByDescCharacter(char charForChecking, List<String> textCollection){
        if (charForChecking == ' '){
            throw new IllegalArgumentException("");
        } else if (textCollection != null) {
            this.charForChecking = charForChecking;

            LinkedList<String> tempList = new LinkedList<>(textCollection);
            Collections.sort(tempList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int o1CountOfChars = getCount(o1);
                    int o2CountOfChars = getCount(o2);

                    if (o1CountOfChars == o2CountOfChars) {
                        return o1.toLowerCase().compareTo(o2.toLowerCase());
                    } else if (o1CountOfChars > o2CountOfChars) {
                        return -1;
                    } else return 1;
                }
            });
            return tempList;
        } else throw new NullPointerException();
    }

    private int getCount(String checkCount) {
        int countOfChars = 0;
        for (char ch : checkCount.toLowerCase().toCharArray()){
            if (ch == charForChecking){
                countOfChars++;
            }
        }
        return countOfChars;
    }
}

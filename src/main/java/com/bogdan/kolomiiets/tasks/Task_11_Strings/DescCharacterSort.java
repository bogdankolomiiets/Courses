package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class DescCharacterSort {
    private static char charForChecking;

    public static List<String> sortListByDescCharacter(char charForChecking, List<String> textCollection){
        if (!Pattern.matches("[a-zA-Z]", charForChecking + "")){
            throw new IllegalArgumentException("Not a letter");
        } else if (textCollection != null && charForChecking != ' ') {
            DescCharacterSort.charForChecking = Character.toLowerCase(charForChecking);

            LinkedList<String> tempList = new LinkedList<>(textCollection);
            Collections.sort(tempList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    o1 = o1.toLowerCase();
                    o2 = o2.toLowerCase();

                    int o1CountOfChars = getCount(o1);
                    int o2CountOfChars = getCount(o2);

                    if (o1CountOfChars == o2CountOfChars) {
                        return o1.compareTo(o2);
                    } else if (o1CountOfChars > o2CountOfChars) {
                        return -1;
                    } else return 1;
                }
            });
            return tempList;
        } else throw new NullPointerException();
    }

    private static int getCount(String checkCount) {
        int countOfChars = 0;
        for (char ch : checkCount.toCharArray()){
            if (ch == charForChecking){
                countOfChars++;
            }
        }
        return countOfChars;
    }
}

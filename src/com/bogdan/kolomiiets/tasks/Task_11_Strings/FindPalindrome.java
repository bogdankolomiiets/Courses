package com.bogdan.kolomiiets.tasks.Task_11_Strings;

import java.util.List;

public class FindPalindrome {
    public static String getMaxLengthPalindrome(List<String> textCollection) {
        if (textCollection != null) {
            if (textCollection.size() > 0) {
                String palindrome = "";
                for (String s : textCollection) {
                    if (s.equalsIgnoreCase(new StringBuffer(s).reverse().toString())) {
                        palindrome = s.length() > palindrome.length() ? s : palindrome;
                    }
                }
                return palindrome.length() > 0 ? "MAX length palindrome is: " + palindrome : "Text has no palindrome";
            } else throw new RuntimeException("List textCollection is empty");
        } else throw new NullPointerException();
    }
}

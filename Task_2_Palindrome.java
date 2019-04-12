package com.bogdan.kolomiiets.tasks;

public class Task_2_Palindrome {
    public static void main(String[] args) {
        checkPalindrome("121");
    }

    private static void checkPalindrome(String isPalindrome){
        String result = "";
        for (int i = 0, j = isPalindrome.length() - 1; i <= j; i++, j--){
            result = isPalindrome.charAt(i) == isPalindrome.charAt(j) ? "It is palindrome" : "It is not palindrome";
        }
        System.out.println(result);
    }
}

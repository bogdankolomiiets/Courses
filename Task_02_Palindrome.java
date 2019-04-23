package com.bogdan.kolomiiets.tasks;

public class Task_02_Palindrome {
    public static void main(String[] args) {
        Task_02_Palindrome palindrome = new Task_02_Palindrome();
        palindrome.getAllBinPalindromeFromInt(0, 500);
    }

    protected void getAllBinPalindromeFromInt(int start, int end) {
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                //convert int value into binary
                String needToCheck = Integer.toBinaryString(i);
                //The loop for check palindrome
                for (int k = 0, l = needToCheck.length() - 1; k <= l; k++, l--) {
                    if (needToCheck.charAt(k) == needToCheck.charAt(l) && k < l) {
                        continue;
                    } else {
                        if (needToCheck.charAt(k) == needToCheck.charAt(l) && k == l) {
                            System.out.println("binary value " + needToCheck + " for " + i + " is palindrome.");
                        } else break;
                    }
                }
            }
        } else { throw new IllegalArgumentException(); }
    }
}

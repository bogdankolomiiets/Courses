package com.bogdan.kolomiiets.tasks;

import java.util.Arrays;

public class Task_04_IdenticalNumbers {
    public static void main(String[] args) {
        //create two int arrays
        int[] firstArray = {10, 20, 30, 50, 15};
        int[] secondArray = {5, 20, 15, 40, 50};

        //check identical numbers in both arrays
        checkIdenticalNumbers(firstArray, secondArray);
    }

    private static void checkIdenticalNumbers(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] == arrayB[j]) System.out.println("Both arrays contains value: " + arrayA[i]);
            }
        }
    }
}

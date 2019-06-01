package com.bogdan.kolomiiets.tasks;

import java.util.ArrayList;
import java.util.List;

public class Task_04_IdenticalNumbers {
    protected List<Integer> identical;

    public static void main(String[] args) {
        Task_04_IdenticalNumbers numbers = new Task_04_IdenticalNumbers();

        //create two int arrays
        int[] firstArray = {10, 20, 30, 50, 15};
        int[] secondArray = {5, 20, 15, 40, 50, 0};

        //check identical numbers in both arrays
        numbers.checkIdenticalNumbers(firstArray, secondArray);
        //display identical numbers
        numbers.displayResults();
    }

    protected void checkIdenticalNumbers(int[] arrayA, int[] arrayB) {
        identical = new ArrayList<>();
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] == arrayB[j]) {
                    identical.add(arrayA[i]);
                }
            }
        }
    }

    private void displayResults(){
        if (identical.size() > 0) {
            for (Integer i : identical) {
                System.out.println("Both arrays contains value: " + i);
            }
        } else System.out.println("Arrays not contains unique values");
    }
}

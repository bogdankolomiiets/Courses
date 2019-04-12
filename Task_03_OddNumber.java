package com.bogdan.kolomiiets.tasks;

public class Task_03_OddNumber {
    public static void main(String[] args) {
        int[] array = {49, 10, 20, 49, 30, 50, 44, 23};
        showMaxOdd(array);
    }

    private static void showMaxOdd(int[] arr){
        int maxOdd = 0;
        for (int i = 0; i < arr.length; i++) {
            maxOdd = arr[i] % 2 != 0 ? maxOdd > arr[i] ? maxOdd : arr[i] : 0;
        }

        switch (maxOdd){
            case 0 :
                System.out.println("Array has no odd number");
                break;

                default:
                    System.out.println("Max odd number is " + maxOdd);
                    break;
        }

    }
}

package com.bogdan.kolomiiets.tasks;

public class Task_03_OddNumber {
    protected int maxOdd = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Task_03_OddNumber oddNumber = new Task_03_OddNumber();
        oddNumber.showMaxOdd(new int[] {73, 49, 10, 20, 49, 30, 50, 44, 51, 23});
    }

    protected void showMaxOdd(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            maxOdd = arr[i] % 2 != 0 ? maxOdd > arr[i] ? maxOdd : arr[i] : maxOdd;
        }

        switch (maxOdd){
            case Integer.MIN_VALUE :
                System.out.println("Array has no odd number");
                break;

                default:
                    System.out.println("Max odd number is " + maxOdd);
                    break;
        }

    }
}

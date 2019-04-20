package com.bogdan.kolomiiets.tasks;

public class Task_05_PositiveNumbers {
    public static void main(String[] args) {
        int[][] arrayA = new int[7][5];
        for (int i = 0; i < arrayA.length; i++){
            for (int j = 0; j < arrayA[i].length; j++) {
                arrayA[i][j] = (int)(Math.random() * (11 - -11) + -11);
            }
        }

        arrayA = createPositiveArray(arrayA);
        printArray(arrayA);
        //Finding out row number, where average is MAX
        System.out.println("Average is MAX in row: " + findOutRowNumber(arrayA));

    }

    private static int[][] createPositiveArray(int[][] array) {
        int[][] newArr = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int value = array[i][j];
                if (value >= 0) {
                    newArr[i][j] = value;
                }
            }
        }
        return newArr;
    }

    private static int findOutRowNumber(int[][] array){
        int count = 0;
        int rowNumber = 0;

        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j = 0; j < array[i].length; j++){
                temp += array[i][j];
            }
            if (temp > count){
                count = temp;
                rowNumber = i;
            }
        }
        return rowNumber;
    }

    private static void printArray(int[][] arrForPrint){
        for (int i = 0; i < arrForPrint.length; i++){
            for (int j = 0; j < arrForPrint[i].length; j++){
                System.out.print(arrForPrint[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

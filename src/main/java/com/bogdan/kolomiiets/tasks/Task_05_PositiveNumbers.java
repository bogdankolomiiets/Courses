package com.bogdan.kolomiiets.tasks;

public class Task_05_PositiveNumbers {
    protected static int[][] arrayA;

    public static void main(String[] args) {
        Task_05_PositiveNumbers positiveNumbers = new Task_05_PositiveNumbers();
        //create new array
        positiveNumbers.createAndFeelStartArray(5, 7);
        //create array with positive numbers
        arrayA = positiveNumbers.createPositiveArray(arrayA);
        printArray(arrayA);
        //Finding out row number, where average is MAX
        System.out.println("Average is MAX in row: " + positiveNumbers.findOutRowNumber(arrayA));

    }

    protected void createAndFeelStartArray(int a, int b) {
        //if a and b = 0 then a and b = 10
        int c = a > 1 ? a : 10;
        int k = b > 1 ? b : 10;
        arrayA = new int[c][k];
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayA[i].length; j++) {
                arrayA[i][j] = (int) (Math.random() * (11 - -11) + -11);
            }
        }
    }

    protected int[][] createPositiveArray(int[][] array) {
        if (array.length > 0 && array != null) {
            int[][] newArr = new int[array.length][array[0].length];

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    int value = array[i][j];
                    if (value >= 0) {
                        newArr[i][j] = value;
                    }
                }
            }
            return newArr;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    private int findOutRowNumber(int[][] array){
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

    protected static void printArray(int[][] arrForPrint){
        for (int i = 0; i < arrForPrint.length; i++){
            for (int j = 0; j < arrForPrint[i].length; j++){
                System.out.print(arrForPrint[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

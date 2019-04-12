package com.bogdan.kolomiiets.tasks;

import java.util.Scanner;

public class Task_1_Letter {
    public static void main(String[] args) {
        solution_One();
    }


    //first solution
    private static void solution_One(){
        String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String userChar = "";
        int counter = 0;
        int userAlphabetIndex = 0;

        //get randomise index
        int randIndex = (int) (Math.random() * enAlphabet.length());
        //get randomise character
        char randChar = enAlphabet.charAt(randIndex);

        //create scanner object
        Scanner scanner = new Scanner(System.in);

        //logic
        System.out.println("Guess the letter of the English alphabet");

        do {
            //wait user character
            userChar = scanner.nextLine().toUpperCase();

            //find out index of user character in alphabet
            userAlphabetIndex = enAlphabet.indexOf(userChar);

            //if user entered non english symbol
            if (userAlphabetIndex < 0) System.out.println("Please read the rules of the game");
            else {
                counter++;
                if (userAlphabetIndex > randIndex) System.out.println("Too high!");
                else if (userAlphabetIndex < randIndex) System.out.println("Too low!");
            }
        } while (!userChar.equalsIgnoreCase(String.valueOf(randChar)));


        System.out.println("WOW... CONGRATULATION!!!\nYou guessed a letter for " + counter +  " times");
    }
}

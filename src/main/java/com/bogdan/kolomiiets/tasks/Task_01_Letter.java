package com.bogdan.kolomiiets.tasks;

import java.util.Scanner;

public class Task_01_Letter {
    protected String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String userChar = "";
    private int counter = 0;
    private int userAlphabetIndex = 0;
    private Scanner scanner;
    protected int randIndex;
    private char randChar;

    public static void main(String[] args) {
        Task_01_Letter letter = new Task_01_Letter();
        letter.makeRandomLetter();
        letter.userGuessing();
    }

    protected void makeRandomLetter() {
        //get random index
        randIndex = (int) (Math.random() * enAlphabet.length());

        //get random character
        randChar = enAlphabet.charAt(randIndex);
    }

    protected void userGuessing(){
        //create scanner object
        scanner = new Scanner(System.in);

        //program made a letter
        System.out.println("Try guess the letter of the English alphabet");

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

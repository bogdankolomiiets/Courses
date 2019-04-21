package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        gameInitialise();
    }

    protected static void gameInitialise() {
        //create cards deck and mix them
        CardDeck deck = new CardDeck();
        deck.mixDeck(50);

        //init gamers count
        System.out.println("Please enter games count...from 2 to 4");
        int gamersCount = 0;
        do {
            try {
                gamersCount = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ONLY NUMBER!!!");
            }
        }
        while (gamersCount < 2 || gamersCount > 4);
        System.out.println("Count of gamers = " + gamersCount);
        System.out.println("GAME STARTED!!!\n");
        GameStart game = new GameStart(deck, gamersCount);
    }
}

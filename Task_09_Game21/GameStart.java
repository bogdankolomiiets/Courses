package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.ArrayList;
import java.util.List;

public class GameStart {

    private CardDeck deck;
    private int gamersCount;
    List<Gamers> gamers = new ArrayList<>();

    public GameStart(CardDeck deck, int gamersCount) {
        this.deck = deck;
        this.gamersCount = gamersCount;

        initUser();
        //init another gamers
        initAnotherGamers();
        //choose a banker
        setRandBanker();
<<<<<<< HEAD
        //set one card for all gamers
        setOneCard();
=======
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90
    }

    private void initUser(){
        User user = new User();
        gamers.add(user);
        gamersCount--;
    }

    private void initAnotherGamers(){
        for (int i = 0; i < gamersCount; i++){
<<<<<<< HEAD
            gamers.add(new Computer(i+2));
=======
            gamers.add(new Computer(i+1));
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90
        }
    }

    private void setRandBanker(){
<<<<<<< HEAD
        int random = (int) (Math.random() * gamers.size());
        gamers.get(random).setBanker(true);
        System.out.println("Banker are: " + gamers.get(random));
        //set banker to 0 index in array

    }

    private void setOneCard(){
        for (Gamers g : gamers){
            g.setOneCard(deck.getCard());
        }
=======
        gamers.get((int) (Math.random() * gamers.size())).setBanker(true);
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90
    }
}

package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStart {

    private CardDeck deck;
    private int gamersCount;
    List<Gamers> gamers = new ArrayList<>();

    public GameStart(CardDeck deck, int gamersCount) {
        this.deck = deck;
        this.gamersCount = gamersCount;

        initGamers();

        //choose a banker
        setRandBanker();

        //get one card for all gamers
        getOneCard();
    }

    private void initGamers(){
        User user = new User();
        gamers.add(user);
        gamersCount--;
        //init another gamers
        initAnotherGamers();
    }

    private void initAnotherGamers(){
        for (int i = 0; i < gamersCount; i++){
            gamers.add(new Computer(i+2));
        }
    }

    private void setRandBanker(){
        int random = (int) (Math.random() * gamers.size());
        gamers.get(random).setBanker(true);
        System.out.println("Banker are: " + gamers.get(random));
        //set banker to 0 index in array
        Collections.sort(gamers, new CompareGamers());
    }

    private void getOneCard(){
        for (Gamers g : gamers){
            g.getOneCard(deck.getCard());
        }
    }
}

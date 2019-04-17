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
        initAnotherUsers();
        System.out.println(gamers);
    }

    private void initUser(){
        User user = new User();
        gamers.add(user);
        gamersCount--;
    }

    private void initAnotherUsers(){
        for (int i = gamersCount; i > 0; i--){
            gamers.add(new Computer(i));
        }
    }
}

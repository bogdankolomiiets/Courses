package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStart {

    private CardDeck deck;
    private int gamersCount;
    private int bankMoney;
    private List<Gamers> gamers = new ArrayList<>();
    private List<Gamers> lostGamers;

    public GameStart(CardDeck deck, int gamersCount) {
        this.deck = deck;
        this.gamersCount = gamersCount;

        initGamers();

        //choose a banker
        setRandBanker();

        //get one card for all gamers
        getOneCard();

        //make bets
        makeBets();

        //get card for all gamers again
        getOneCard();

        //scoring
        while (!scoring() && gamers.size() > 1) {
            getOneCard();
        }

        Gamers g = gamers.get(0);
        if (gamers.size() == 1 && g.getScore() <= 21){
            System.out.println("\n" + g + " scored " + g.getPlayingCards() + " = "
                    + g.getScore() + ". " + g + " WON. CONGRATULATION!!!");
        }
    }

    protected void initGamers(){
        User user = new User();
        user.setMoneyCount(250);
        gamers.add(user);
        gamersCount--;
        //init another gamers
        initAnotherGamers();
    }

    protected void initAnotherGamers(){
        for (int i = 0; i < gamersCount; i++){
            gamers.add(new Computer(i+2));
        }
        for (Gamers g : gamers){
            g.setMoneyCount(250);
        }
    }

    protected void setRandBanker(){
        int random = (int) (Math.random() * gamers.size());
        gamers.get(random).setBanker(true);
        System.out.println("Banker are: " + gamers.get(random));
        //set banker to 0 index in array
        Collections.sort(gamers, new CompareGamers());
    }

    protected void getOneCard(){
        for (Gamers g : gamers){
            //if count of cards less then 5 then get new card
            if (g.getPlayingCards().size() < 5){
                g.addCard(deck.getCard());
            }
        }
    }

    protected void makeBets() {
        //banker first
        int tempMoney = gamers.get(0).getMoneyCount();
        bankMoney = tempMoney;
        System.out.println("\nBanker made max bet: " + tempMoney);
        gamers.get(0).setMoneyCount(gamers.get(0).getMoneyCount() - tempMoney);

        //another gamers make bets
        int maxBetPerGamer = bankMoney / (gamers.size() - 1);
        for (int i = 1; i < gamers.size(); i++){
            bankMoney += maxBetPerGamer;
            gamers.get(i).setMoneyCount(gamers.get(i).getMoneyCount() - maxBetPerGamer);
            System.out.println(gamers.get(i) + " made a bet " + maxBetPerGamer);
        }
        System.out.println("\nTotal bankMoney = " + bankMoney);
    }

    protected boolean scoring() {
        lostGamers = new ArrayList<>();
        for (Gamers g : gamers) {
            //reset score
            g.resetScore();

            for (PlayingCards cards : g.getPlayingCards()) {
                switch (cards) {
                    case JACK:
                        g.setScore(2);
                        break;
                    case QUEEN:
                        g.setScore(3);
                        break;
                    case KING:
                        g.setScore(4);
                        break;
                    case SIX:
                        g.setScore(6);
                        break;
                    case SEVEN:
                        g.setScore(7);
                        break;
                    case EIGHT:
                        g.setScore(8);
                        break;
                    case NINE:
                        g.setScore(9);
                        break;
                    case TEN:
                        g.setScore(10);
                        break;
                    case ACE:
                        g.setScore(11);
                        break;
                }
            }
            if (g.getScore() < 21) {
                continue;
            }
            //if score = 21 then gamer WON
            if (g.getScore() == 21) {
                g.setMoneyCount(bankMoney);
                System.out.println("\nWOW... " + g + " WON " + bankMoney + "$. CONGRATULATION!!!");
                bankMoney = 0;
                return true;
            } else {
                //if score > 21 then gamer lost
                if (g.getScore() > 21) {
                    lostGamers.add(g);
                }
            }
        }
        removeLostGamer();
        return false;
    }

    protected void removeLostGamer(){
        if (lostGamers.size() == (gamersCount + 1)){
            System.out.println("ALL GAMERS GOT MORE THAN 21 SCORES - TRY AGAIN");
            System.exit(0);
        } else {
            for (int i = 0; i < lostGamers.size(); i++) {
                System.out.println(lostGamers.get(i) + " LOST!!!");
                gamers.remove(lostGamers.get(i));
                lostGamers.remove(i);
            }
        }
    }
}

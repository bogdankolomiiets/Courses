package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.LinkedList;
import java.util.List;

public class CardDeck {
    List<PlayingCards> playingCardDeck = new LinkedList<>();

    public CardDeck() {
        addCardToDeck();
    }

    private void addCardToDeck() {
        //create a deck of 36 cards
        for (int i = 0; i < 4; i++) {
            for (PlayingCards cards : PlayingCards.values()) {
                playingCardDeck.add(cards);
            }
        }
    }

    public PlayingCards getCard(){
        PlayingCards card = playingCardDeck.get(0);
        playingCardDeck.remove(0);
        return card;
    }

    //mixed a deck specified number of times
    protected void mixDeck(int times) {
        //check times value
        times = times > 0 ? times : 50;

        List<PlayingCards> tempCardsList;
        List<PlayingCards> subList;
        while (times > 0) {
            int start = (int) (Math.random() * playingCardDeck.size()-1);
            int end = getRandomIntInRangeInclusive(start + 1, playingCardDeck.size() - 1);

            //made subList with random count
            subList = playingCardDeck.subList(start, end + 1);
            //add sublist to LinkedList
            tempCardsList = new LinkedList<>(subList);

            //remove cards from playingCardDeck
            for (int i = end; i >= start; i--) {
                playingCardDeck.remove(i);
            }

            //add cards from tempCardsList into playingCardDeck
            for (int i = 0; i < tempCardsList.size(); i++) {
                int index = (int) (Math.random() * playingCardDeck.size());
                playingCardDeck.add(index, tempCardsList.get(i));
            }

            times--;
        }
    }

    protected int getRandomIntInRangeInclusive(int min, int max) {
        //return random number in range between min and max inclusive
        if (min <= max) {
            return (int) (Math.random() * (max - min + 1) + min);
        } else {
            System.out.println("max value too low!!!");
            throw new IllegalArgumentException();
        }
    }
}

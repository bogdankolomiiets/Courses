package com.bogdan.kolomiiets.tasks.Task_09_Game21;

import java.util.*;

public class CardDeck {
    List<PlayingCards> playingCardDeck = new ArrayList<>();

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

<<<<<<< HEAD
    public PlayingCards getCard(){
        PlayingCards card = playingCardDeck.get(0);
        playingCardDeck.remove(0);
        return card;
    }

=======
>>>>>>> 2e3fe7bc6940b330e17c11dcf05b13f088c1be90
    //mixed a deck specified number of times
    public void mixDeck(int times) {
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

    private int getRandomIntInRangeInclusive(int min, int max) {
        //return random number in range between min and max inclusive
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

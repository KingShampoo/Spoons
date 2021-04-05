package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class AI extends Player {

    public AI(ArrayList<Card> deck) {
        for (int i = 0; i < 4; i++) {
            hand.add(deck.get(0));
            deck.remove(0);
        }
    }

    public void playARound(ArrayList<Card> Deck, Stack<Card> DiscardPile) {
        int bestCardValue = 0;
        int numberOfBestCard = 0;
        Card topOfDeck = Deck.get(0);
        Card topOfDiscard = DiscardPile.peek();

        for (int i = 0; i < 5; i++) {//nested for loop picks one of the 5 known cards as a pointer and compares values to see how many matches there is using loop j
            int pointerMatches = 0;
            Card pointerCard;
            if (i == 4)
                pointerCard = topOfDeck;
            else {
                pointerCard = hand.get(i);
            }

            for (int j = 0; j < 5; j++) {
                if (j == 4) {
                    if (pointerCard.getValue() == topOfDiscard.getValue())
                        pointerMatches++;
                } else {
                    if (pointerCard.getValue() == hand.get(j).getValue())
                        pointerMatches++;
                }
            }
            if (pointerMatches >= numberOfBestCard) {//if this current pointer has more matches than the last best replace it as the best card to look for
                bestCardValue = pointerCard.getValue();
                numberOfBestCard = pointerMatches;
            }
        }

            if (bestCardValue == topOfDiscard.getValue()) {//if the top of the discard is the card were looking for we add it to the hand and then look for a card that is a throwaway card
                hand.add(topOfDiscard);
                int index = 0;

                while (true) {
                    if (hand.get(index).getValue() == bestCardValue) {//if the current index has the value of the card were looking for, skip it while looking to discard something
                        index++;
                        continue;
                    } else {
                        Card token = hand.get(index);//removes a card from the hand and then pushes it into the discard Stack
                        hand.remove(index);
                        DiscardPile.push(token);
                        break;
                    }
                }
            } else {//if the discard card isnt a match, takes one from the deck
                hand.add(topOfDeck);
                int index = 0;

                while (true) {//replaces a throw away card with the top of deck card
                    if (hand.get(index).getValue() == bestCardValue) {
                        index++;
                    } else {
                        Card token = hand.get(index);//removes a card from the hand and then pushes it into the discard Stack
                        hand.remove(index);
                        DiscardPile.push(token);
                        break;
                    }
                }
            }
    }
}

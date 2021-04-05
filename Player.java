package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Player {
    ArrayList<Card> hand = new ArrayList<>();

    public Player() {}

    public Player(ArrayList<Card> deck) {
        for (int i = 0; i < 4; i++) {
            hand.add(deck.get(0));
            deck.remove(0);
        }
    }

    public  boolean checkIfWin(){
        int pairs = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getValue()==hand.get(0).getValue())
                pairs++;
        }
        if (pairs==4)
            return true;//if 4 of same card value = win
        return false;//else didnt win
    }
    public void takeFromDiscard(Stack<Card> discardPile){
        hand.add(discardPile.pop());
    }

    public void takeFromDeck(ArrayList<Card> deck){
        hand.add(deck.get(0));
        deck.remove(0);
    }//takes card from shuffled deck

    public void putInDiscard(Stack<Card> discardPile, int index){
        Card token = hand.get(index);
        hand.remove(index);
        discardPile.push(token);
    }

    @Override
    public String toString() {
        String print = "";
        for (Card c : hand)
            print = print + c.toString() + "\n";
        return print;
    }
}

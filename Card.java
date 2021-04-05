package com.company;

public class Card {
    private int value;
    private int suitValue;
    private String suit;
    private String sValue;

    public Card(int suitValue, int value) {
        this.value = value;
        this.suitValue = suitValue;

        if (suitValue==0)
            this.suit="Clubs";
        if (suitValue==1)
            this.suit="Spades";// setting suit
        if (suitValue==2)
            this.suit="Hearts";
        if (suitValue==3)
            this.suit="Diamonds";

        this.sValue = String.valueOf(value);
        if (value ==1)
            this.sValue="Ace";
        if (value ==11)
            this.sValue="Jack";//these special cards name arent the same as their value
        if (value ==12)
            this.sValue="Queen";
        if (value ==13)
            this.sValue = "King";
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return (sValue + " of " + suit);
    }
}

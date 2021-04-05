package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<>();
        Stack<Card> discardPile = new Stack<>();

        for (int suit = 0; suit < 4; suit++) {
            for (int value = 1; value < 13; value++) {//makes the deck by cycling through each suit and then values
                Card newCard = new Card(suit, value);
                deck.add(newCard);
            }
        }

        Collections.shuffle(deck);//shuffles the deck

        Player Player1 = new Player(deck);//initializing all players n bots
        AI bot1 = new AI(deck);
        AI bot2 = new AI(deck);
        AI bot3 = new AI(deck);

        Scanner sc = new Scanner(System.in);//init a scanner for user input

        while (true){
            System.out.println("Your Cards are:");
            System.out.println(Player1.toString());
            if (!discardPile.empty())
                System.out.println("the top of the discard is :" + discardPile.peek().toString());
            else
                System.out.println("Discard pile is currently empty \n");
            System.out.println("Would you like to draw randomly from the deck or the discard pile?");
            System.out.println("1 for deck");
            if (!discardPile.empty())
                System.out.println("2 for discard pile");
            int choice = sc.nextInt();
            if (choice==1) {
                Player1.takeFromDeck(deck);
            }
            if (choice==2){
                Player1.takeFromDiscard(discardPile);
            }
            System.out.println("What card would you like to discard");
            for (int i = 0; i < 5; i++) {
                System.out.println(i + ": " + Player1.hand.get(i).toString());
            }
            choice = sc.nextInt();
            Player1.putInDiscard(discardPile,choice);
            if (Player1.checkIfWin()==true) {
                System.out.println("You win!");
                System.out.println(Player1.toString());
                break;
            }

            bot1.playARound(deck,discardPile);
            if (bot1.checkIfWin() == true) {
                System.out.println("Bot 1 wins!");
                System.out.println(bot1.toString());
            break;
            }

            bot2.playARound(deck,discardPile);
            if (bot2.checkIfWin() == true){
                System.out.println("Bot 2 wins!");
                System.out.println(bot2.toString());
                break;
            }

            bot3.playARound(deck,discardPile);
            if (bot3.checkIfWin() == true){
                System.out.println("Bot 3 wins!");
                System.out.println(bot3.toString());
                break;
            }
        }
    }
}

package main;

import java.util.Collections;
import java.util.ArrayList;


public class Deck {

    String[] Deck = new String[52];
    ArrayList<String> shuffled = new ArrayList<>();

    void init(){
        makeDeck();
        shuffleDeck();
    }

    // Make the deck
    String[] suits = {
            "Clubs", "Diamonds", "Hearts", "Spades"
    };

    String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };


    public void makeDeck() {

        int i = 0;

        for (String rank : ranks) {
            for (String suit : suits) {
                Deck[i] = rank;
                i++;
            }
        }
    }

    public ArrayList<String> shuffleDeck() {
        // Shuffle the deck
        Collections.addAll(shuffled, Deck);
        Collections.shuffle(shuffled);
        return shuffled;
    }


    public String getCard(){
        // Get the first card from the shuffled deck then remove it
        String card = shuffled.get(0);
        shuffled.remove(0);
        return card;
    }

    public void printDeck() {
        for (int i = 0; i < shuffled.size(); i++) {
            System.out.println(shuffled.get(i));
        }
    }

}



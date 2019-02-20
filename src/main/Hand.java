package main;

import java.util.ArrayList;

public class Hand {
    ArrayList<String> cardhand = new ArrayList();
    int aceCounter;
    int totalScore;

    public void addCard(String card){
        cardhand.add(card);
    }

    public void printHand(){
        System.out.print("Your hand is: " + cardhand + ".");
    }

    public void dealerprintHand(){
        System.out.print("Dealer's hand is: " + cardhand + ".");
    }

    public void printFirst(){
            System.out.println("[" + cardhand.get(0) + ", ?]");
    }

    public int cardTotal(){
        totalScore = 0;
        aceCounter = 0;
        for (Object card : cardhand){
            if (card == "King" || card == "Queen" || card == "Jack"){
                totalScore += 10;
            } else if(card == "Ace"){
                totalScore += 11;
                aceCounter += 1;
            } else {
                totalScore += Integer.parseInt(card.toString().trim());
            }
        }
        while (aceCounter > 0 && totalScore > 21){
            totalScore -= 10;
            aceCounter -= 1;
        }
        return totalScore;
    }

}

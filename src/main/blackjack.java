package main;

import java.util.Scanner;


public class blackjack {

    public static boolean playerStick = false;
    public static Deck cardDeck = new Deck();

    public static Hand playerHand = new Hand();
    public static Hand dealerHand = new Hand();

    public static void main(String[] args) {
        cardDeck.init();


        for (int i = 0; i < 2; i++) {
            playerHand.addCard(cardDeck.getcard());
            dealerHand.addCard(cardDeck.getcard());
        }

        System.out.println("Welcome to blackjack");
        playerHand.printHand();
        System.out.println(" Your total score is: " + playerHand.cardTotal() + ".");
        System.out.print("The Dealer's hand is ");
        dealerHand.printFirst();



        while (playerHand.cardTotal() < 21 && !playerStick) {
            game();
        }
        if (playerStick || playerHand.cardTotal() == 21) {
            faceOff();
        }
        else if (playerHand.cardTotal() > 21) {
            System.out.println("You're bust - better luck next time.");
        }

    }


        public static Boolean game() {

        Scanner user_input = new Scanner(System.in);

                System.out.println("Would you like to stick (s) or twist (t)?");

                String choice = user_input.next();

                if (choice.trim().equals("t")) {
                    playerHand.addCard(cardDeck.getcard());
                    playerHand.cardTotal();
                    if (playerHand.cardTotal() == 21) {
                        playerHand.printHand();
                        System.out.println(" Your total score is: " + playerHand.cardTotal() + ".");
                    } else {
                        playerHand.printHand();
                        System.out.println(" Your total score is: " + playerHand.cardTotal() + ".");
                    }
                } else if (choice.trim().equals("s")) {
                    playerStick = true;
                    if (playerHand.cardTotal() == 21) {
                        playerHand.printHand();
                        System.out.println(" Your total score is: " + playerHand.cardTotal() + ".");
                    } else {
                        playerHand.printHand();
                        System.out.println(" Your total score is: " + playerHand.cardTotal() + ".");
                        System.out.println("Now let's see how the dealer's turn goes...");
                    }
                } else {
                    System.out.println("Sorry your choice was not recognised. Please try again");
                }
                return playerStick;
            }


        public static void faceOff(){
            if(playerHand.cardTotal() == 21){
               if (dealerHand.cardTotal() == 21){
                   dealerHand.dealerprintHand();
                   System.out.println(" Dealer's total score is: " + dealerHand.cardTotal() + ".");
                   System.out.println("It's a draw");
               } else {
                   dealerHand.dealerprintHand();
                   System.out.println(" Dealer's total score is: " + dealerHand.cardTotal() + ".");
                   System.out.println("You win!");
               }

            } else {
               if (dealerHand.cardTotal() < 17){
                   if (dealerHand.cardTotal() > playerHand.cardTotal()){
                       dealerHand.dealerprintHand();
                       System.out.println(" Dealer's total score is: " + dealerHand.cardTotal() + ".");
                       System.out.println("Dealer wins.");
                   }
                   while (dealerHand.cardTotal() < playerHand.cardTotal()) {
                       dealerHand.dealerprintHand();
                       System.out.println(" Dealer's total score is: " + dealerHand.cardTotal() + ".");
                       dealerHand.addCard(cardDeck.getcard());
                   }
               }
                if (dealerHand.cardTotal() == 21){
                    dealerHand.dealerprintHand();
                    System.out.println(" Dealer's total score is: " + dealerHand.cardTotal() + ".");
                    System.out.println("Dealer wins.");
                }
                if (dealerHand.cardTotal() < 21 && dealerHand.cardTotal() > playerHand.cardTotal()){
                    dealerHand.dealerprintHand();
                    System.out.println(" Dealer's total score is: " + dealerHand.cardTotal() + ".");
                    System.out.println("Dealer wins.");
                }
                if (dealerHand.cardTotal() > 21 && playerHand.cardTotal() < 22){
                    dealerHand.dealerprintHand();
                    System.out.println(" Dealer's total score is: " + dealerHand.cardTotal() + ".");
                    System.out.print("Dealer is bust - You win!!");
                }
           }
        }
    }




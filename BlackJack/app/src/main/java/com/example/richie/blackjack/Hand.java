package com.example.richie.blackjack;
import java.util.ArrayList;
/**
 * Add class description including @author and @version
 */
public class Hand
{
    //Stores the score and cards in hand
    private int highHandValue; // for the high value of ace
    private int lowHandValue; // for the low value of ace
    private Card [] hand;
    private Deck deck;
    private final int MAX_CARDS_IN_HAND = 5;

    /**
     * Creates a hand with two cards
     */
    public Hand(int numDecks)
    {
        deck = new Deck(numDecks);
        hand = dealNewHand();
        highHandValue = highHandValue();
        lowHandValue = lowHandValue();
    }

    /**
     * Creates a new hand for the player or dealer
     * @return new hand of two cards
     */
    public Card [] dealNewHand()
    {
        Card [] newHand = new Card[MAX_CARDS_IN_HAND]; //max num of cards in a hand is ten
        newHand[0] = deck.dealCard();
        newHand[1] = deck.dealCard();
        return newHand;
    }

    /**
     * Determines the value of the current hand with aces high
     * @return the value of the current hand aces high
     */
    public int highHandValue()
    {
       int cardTotal = 0;
       for (Card currentHandCard : hand) {
           if (currentHandCard != null) {
               if (currentHandCard.getCardNum() == 'J' || currentHandCard.getCardNum() == 'Q' || currentHandCard.getCardNum() == 'K') {
                   cardTotal += 10;
               } else if (currentHandCard.getCardNum() == 'A') {
                   cardTotal += 11;
               } else
                   cardTotal += currentHandCard.getCardNum() - '0';
           }
       }
       return cardTotal;
    }

    /**
     * Determines the value of the current hand with aces low
     * @return the value of the current hand aces low
     */
    public int lowHandValue()
    {
        int cardTotal = 0;
        for (Card currentHandCard : hand) {
            if (currentHandCard != null) {
                if (currentHandCard.getCardNum() == 'J' || currentHandCard.getCardNum() == 'Q' || currentHandCard.getCardNum() == 'K') {
                    cardTotal += 10;
                } else if (currentHandCard.getCardNum() == 'A') {
                    cardTotal += 1;
                } else
                    cardTotal += currentHandCard.getCardNum() - '0';
            }
        }
        return cardTotal;
    }

    /**
     * Adds a card to the hand
     */
    public void hit()
    {
        int index = 0;
        while(hand[index] !=null)
        {
            index++;
        }
        hand[index] = deck.dealCard();
        lowHandValue = lowHandValue();
        highHandValue = highHandValue();
    }

    /**
     * Gives a string representation of the hand
     * @return the hand as a string
     */
    public String handString()
    {
        String result = "";
        for(Card currentCard: hand)
        {
            if (currentCard != null)
            {
                result += cardString(currentCard) + ":";
            }
        }
        return result;
    }

    /**
     * gives a string representation of the card
     * @param card the card to be converted to a string
     * @return card as a string
     */
    public String cardString(Card card)
    {
        char rank = card.getCardNum();
        String cardResultString = "";
        switch (rank)
        {
            case '2': cardResultString = "two_of_";
                break;
            case '3': cardResultString = "three_of_";
                break;
            case '4': cardResultString = "four_of_";
                break;
            case '5': cardResultString = "five_of_";
                break;
            case '6': cardResultString = "six_of_";
                break;
            case '7': cardResultString = "seven_of_";
                break;
            case '8': cardResultString = "eight_of_";
                break;
            case '9': cardResultString = "nine_of_";
                break;
            case '0': cardResultString = "ten_of_";
                break;
            case 'J': cardResultString = "jack_of_";
                break;
            case 'Q': cardResultString = "queen_of_";
                break;
            case 'K': cardResultString = "king_of_";
                break;
            case 'A': cardResultString = "ace_of_";
                break;

        }
        char suit = card.getCardSuit();
        switch(suit)
        {
            case 'H': cardResultString += "hearts";
                break;
            case 'D': cardResultString += "diamonds";
                break;
            case 'S': cardResultString += "spades";
                break;
            case 'C': cardResultString += "clubs";
                break;
        }
        return cardResultString;
    }

}

package com.example.richie.blackjack;
/**
 * You need to wrie a class description on top of every class. For example
 * This class represents a Card object
 * @author Richie Kogut
 * @version 1.0 10/05/2018
 */
public class Card
{
    //Instance variables for the cards number and suit
    /** Decribe the instance variable. E.g., the suit of the Card */
    private char cardSuit;
    /** The numeric value of the Card */
    private char cardNum;
    
    private boolean drawnStatus;
    /**
     * Constructor that initializes the suit and value of the card
     * @param suit The suit of the card
     * @param num The value of the of card
     */
    public Card(char suit, char num)
    {
        cardSuit = suit;
        cardNum = num;
    }

    /**
     * Gives the suit of the card
     * @return card suit
     */
    public char getCardSuit()
    {
        return cardSuit;
    }

    /**
     * Gives the value of the card rank
     * @return card rank
     */
    public char getCardNum()
    {
        return cardNum;
    }

    /**
     * Determines if the card has been drawn
     * @return true if card is drawn; false otherwise
     */
    public boolean isDrawn()
    {
        return drawnStatus;
    }

    /**
     * Indicates the card has been drawn
     */
    public void cardDrawn()
    {
        drawnStatus = true;
    }


}

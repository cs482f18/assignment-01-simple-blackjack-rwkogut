package com.example.richie.blackjack;

public class Card
{
    //Instance variables for the cards number and suit
    private char cardSuit;
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

package com.example.richie.blackjack;

public abstract class Participant
{
    // attributes for current hand the player has
    protected Hand hand;
    protected int lowHandValue;
    protected int highHandValue;

    /**
     * Determines if the current hand is a bust in blackjack
     * @param handValue
     * @return
     */
    public boolean handBust(int handValue)
    {
        if (lowHandValue > 21)
            return true;
        return false;
    }

    /**
     * Determines if the hand is a blackjack
     * @param handValue the value of the hand
     * @return whether the hand is a blackjack
     */
    public boolean blackjack(int handValue)
    {
        if (lowHandValue == 21 || highHandValue == 21)
            return true;
        return false;
    }

    /**
     * adds a card to the hand and returns the string representation of the hand
     * @return hand string
     */
    public String hit()
    {
        hand.hit();
        lowHandValue = hand.lowHandValue();
        highHandValue = hand.highHandValue();
        return hand.handString();
    }

    /**
     * Resets the participants hand
     */
    public void resetParticipant()
    {
        hand = new Hand(1);
        lowHandValue =  hand.lowHandValue();
        highHandValue = hand.highHandValue();
    }

    /**
     * Gives the string representation of the hand
     * @return hand of the player as a string
     */
    public String giveHandRepresentation()
    {
        return hand.handString();
    }



}

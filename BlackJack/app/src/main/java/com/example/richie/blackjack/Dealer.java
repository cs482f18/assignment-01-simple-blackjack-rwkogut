package com.example.richie.blackjack;

public class Dealer extends Participant
{
    /**
     * Constructor for the Dealer objects; creates a hand of two cards with associated high and low point values
     */
    public Dealer()
    {
        hand = new Hand(1);
        highHandValue = hand.highHandValue();
        lowHandValue = hand.lowHandValue();
    }

    /**
     * Decision making for the dealer to hit or not
     * @return false for stay; true for hit
     */
    public boolean stayOrHit()
    {
        if (handBust(lowHandValue) || blackjack(lowHandValue) || blackjack(highHandValue))
        {
            return false;
        }
        else if (lowHandValue >= 17 || highHandValue >= 17)
        {
            return false;
        }
        return true;
    }

    /**
     * adds another card to the hand
     * @return a string representation of the hand
     */
    @Override
    public String hit()
    {
        if (stayOrHit() == true)
        {
            hand.hit();
            lowHandValue = hand.lowHandValue();
            highHandValue = hand.highHandValue();
            return hand.handString();
        }
        return "No Hit";
    }
}

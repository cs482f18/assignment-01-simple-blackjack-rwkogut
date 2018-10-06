package com.example.richie.blackjack;

public class Player extends Participant
{
    /**
     * Constructor for the Player object; creates a hand of two cards and assigns values for aces high and aces low
     */
    public Player()
    {
        hand = new Hand(1);
        highHandValue = hand.highHandValue();
        lowHandValue = hand.lowHandValue();
    }

}

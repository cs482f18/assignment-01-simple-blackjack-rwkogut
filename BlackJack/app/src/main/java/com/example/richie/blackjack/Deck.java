package com.example.richie.blackjack;

import android.util.Log;

public class Deck
{
    // Array to store the suits
    private char [] suits = {'H', 'D', 'S', 'C'};
    //Array to store the card ranks
    private char [] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K', 'A'};
    //Array of cards to form a deck
    private static Card [] deck;
    //Number of decks in game
    private static int numDecks;

    /**
     * Creates a deck of cards
     */
    public Deck(int decks)
    {
        numDecks = decks;
        deck = createDeck(decks);
    }

    /**
     * Creates a deck for blackjack each card and the number of decks desired
     * @param numOfDecks Number of standard 52 card decks to be included in the blackjack game deck
     * @return blackjack game deck
     */
    public Card [] createDeck(int numOfDecks)
    {
        Card [] gameDeck = new Card[52 * numOfDecks];

        int deckIndex = 0;
        for (int i = 0; i < numOfDecks; i++)
        {
            for (int j = 0; j < suits.length; j++)
            {
                for (int k = 0; k < ranks.length; k++) {
                    gameDeck[deckIndex] = new Card(suits[j], ranks[k]);
                    deckIndex++;
                }
            }
        }

        return gameDeck;
    }

    /**
     * Resets the deck a full deck with no cards drawn
     */
    public void resetDeck()
    {
        deck = createDeck(numDecks);
    }

    /**
     * Deals a card from the deck
     * @return dealt card
     */
    public static Card dealCard()
    {
        int cardDrawIndex = (int) ((Math.random() * 52) * numDecks);

        while (deck[cardDrawIndex].isDrawn() == true)
        {
            cardDrawIndex = (int) ((Math.random() * 52) * numDecks);
        }
        deck[cardDrawIndex].cardDrawn();

        return deck[cardDrawIndex];
    }

    /**
     * Output the deck of cards
     */
    public void outputDeck()
    {
        for(Card target: deck)
        {
            Log.d("Testing","" +target.getCardSuit() + target.getCardNum());
        }
    }

}

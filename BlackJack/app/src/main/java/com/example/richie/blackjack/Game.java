package com.example.richie.blackjack;

import android.content.Intent;

public class Game
{
    //the attributes for the two players in the game
    protected Dealer dealer;
    protected Player player;

    /**
     * constructor for the game that creates both players
     */
    public Game()
    {
        dealer = new Dealer();
        player = new Player();
    }

    /**
     * starts a new game
     * @return the string represenation of the new dealer and player cards
     */
    public String newGame()
    {
        dealer.resetParticipant();
        player.resetParticipant();
        return dealer.giveHandRepresentation() + player.giveHandRepresentation();

    }

    /**
     * determines the result of the game
     * @param playerScore the score of the user
     * @param dealerScore the score of the dealer
     * @return the result of the game; win, loss, or tie
     */
    public String endGame(int playerScore, int dealerScore)
    {
        if (dealer.handBust(dealerScore))
        {
            return "Player Wins";
        }
        else if(player.handBust(playerScore))
        {
            return "Dealer Wins";
        }
        else if(playerScore == dealerScore)
        {
            return "Tie Game";
        }
        else if (dealerScore > playerScore)
        {
            return "Dealer Wins";
        }
        else if (playerScore > dealerScore)
        {
            return "Player Wins";
        }
        return "Not Over";
    }

    /**
     * Determines whether aces should be high or low
     * @return the scores of dealer and player with aces either high or low
     */
    public int[] gameScore()
    {
        int [] gameScores = new int[2];
        if (dealer.handBust(dealer.highHandValue) == true && player.handBust(player.highHandValue) == true)
        {
            gameScores[0] = dealer.lowHandValue;
            gameScores[1] = player.lowHandValue;
        }
        else if (dealer.handBust(dealer.highHandValue) == true)
        {
            gameScores[0] = dealer.lowHandValue;
            gameScores[1] = player.highHandValue;
        }
        else if (player.handBust(player.highHandValue)== true)
        {
            gameScores[0] = dealer.highHandValue;
            gameScores[1] = player.lowHandValue;
        }
        else {
            gameScores[0] = dealer.highHandValue;
            gameScores[1] = player.highHandValue;
        }
        return gameScores;
    }

    /**
     * Gives another card to the players hand
     * @return the string representation of the players hand
     */
    public String hitPlayer()
    {
        return player.hit();
    }

    /**
     * Gives the dealer another card in their hand
     * @return the string representation of the dealers hand
     */
    public String hitDealer()
    {
        return dealer.hit();
    }


}

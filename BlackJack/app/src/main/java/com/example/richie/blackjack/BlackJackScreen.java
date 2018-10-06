package com.example.richie.blackjack;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BlackJackScreen extends AppCompatActivity {

    /**
     * Instructions for when the blackjack game screen starts
     * @param savedInstanceState the instance state of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack_screen);

        //Image View Variables
        final ImageView dealerCardOne = (ImageView) findViewById(R.id.dealerCardOneImageView);
        final ImageView dealerCardTwo = (ImageView) findViewById(R.id.dealerCardTwoImageView);
        final ImageView dealerCardThree = (ImageView) findViewById(R.id.dealerCardThreeImageView);
        final ImageView dealerCardFour = (ImageView) findViewById(R.id.dealerCardFourImageView);
        final ImageView dealerCardFive = (ImageView) findViewById(R.id.dealerCardFiveImageView);
        final ImageView playerCardOne = (ImageView) findViewById(R.id.playerCardOneImageView);
        final ImageView playerCardTwo = (ImageView) findViewById(R.id.playerCardTwoImageView);
        final ImageView playerCardThree = (ImageView) findViewById(R.id.playerCardThreeImageView);
        final ImageView playerCardFour = (ImageView) findViewById(R.id.playerCardFourImageView);
        final ImageView playerCardFive = (ImageView) findViewById(R.id.playerCardFiveImageView);

        //button objects
        final Button hitBtn = (Button) findViewById(R.id.hitBtn);
        final Button stayBtn = (Button) findViewById(R.id.stayBtn);
        final Button quitBtn = (Button) findViewById(R.id.quitBtn);
        final Button newGameBtn = (Button) findViewById(R.id.newGameBtn);

        //TextView objects
        final TextView playerScore = (TextView) findViewById(R.id.playerScoreTextView);
        final TextView dealerScore = (TextView) findViewById(R.id.dealerScoreTextView);
        final TextView gameResult = (TextView) findViewById(R.id.gameResultTextView);



        newGameBtn.setOnClickListener(new View.OnClickListener() {

            /**
             * Instructions for when the new game is selected
             * @param v the view
             */
            @Override
            public void onClick(View v) {
                final Game game = new Game();
                String playerDealerString = game.newGame();
                String cardString [] = playerDealerString.split(":");

                //sets all the graphics to new game values
                int backOfCard = getResources().getIdentifier("@drawable/back", null, getPackageName());
                dealerCardThree.setImageResource(backOfCard);
                dealerCardFour.setImageResource(backOfCard);
                dealerCardFive.setImageResource(backOfCard);
                playerCardThree.setImageResource(backOfCard);
                playerCardFour.setImageResource(backOfCard);
                playerCardFive.setImageResource(backOfCard);
                gameResult.setText("");
                playerScore.setText("");
                dealerScore.setText("");

                //enables the hit button in case stay was selected last game
                hitBtn.setEnabled(true);

                //Displays the two initial deal cards for the player and dealer
                int cardOnePlayer = getResources().getIdentifier("@drawable/" + cardString[2], null, getPackageName());
                playerCardOne.setImageResource(cardOnePlayer);
                int cardTwoPlayer = getResources().getIdentifier("@drawable/" + cardString[3], null, getPackageName());
                playerCardTwo.setImageResource(cardTwoPlayer);
                int cardOneDealer = getResources().getIdentifier("@drawable/" + cardString[0], null, getPackageName());
                dealerCardOne.setImageResource(cardOneDealer);
                int cardTwoDealer = getResources().getIdentifier("@drawable/" + cardString[1], null, getPackageName());
                dealerCardTwo.setImageResource(cardTwoDealer);

                //displays the initial game scores
                final int [] gameScore = game.gameScore();
                playerScore.setText(gameScore[1] + "");
                dealerScore.setText(gameScore[0] + "");

                /**
                 * Instructions for when the hit button is clicked
                 */
                hitBtn.setOnClickListener(new View.OnClickListener() {
                    //number of cards currently in the players hand
                    int playerCardNumber = 3;
                    int dealerCardNumber = 3;

                    //the string representation of the player and dealers hand
                    String playerArray[];
                    String dealerArray[];

                    //scores of the player and dealer
                    int [] score;

                    @Override
                    public void onClick(View v) {

                        //instructions for when the third card is displayed
                        if (playerCardNumber == 3)
                        {
                            //add a card to the player and dealers hand
                            playerArray = game.hitPlayer().split(":");
                            dealerArray = game.hitDealer().split(":");


                            //checks if either the player or dealer has busted
                            if (game.player.handBust(game.player.lowHandValue) || game.dealer.handBust(game.dealer.lowHandValue))
                            {
                                //ends the game cause a bust has occurred
                                hitBtn.setEnabled(false);
                                gameResult.setText(game.endGame(game.gameScore()[1], game.gameScore()[0]));
                            }
                            else {
                                //displays the next card for the player
                                int cardThreePlayer = getResources().getIdentifier("@drawable/" + playerArray[2], null, getPackageName());
                                playerCardThree.setImageResource(cardThreePlayer);
                            }

                            //checks if the dealer has busted
                            if (!(dealerArray[0].equals("No Hit")))
                            {
                                //displays the nest card for the dealer
                                int cardThreeDealer = getResources().getIdentifier("@drawable/" + dealerArray[2], null, getPackageName());
                                dealerCardThree.setImageResource(cardThreeDealer);
                            }

                            //displays the score
                            score = game.gameScore();
                            playerScore.setText(score[1] + "");
                            dealerScore.setText(score[0] + "");
                            playerCardNumber++;
                        }
                        else if (playerCardNumber == 4)
                        {
                            //instructions for when the fourth card is displayed
                            playerArray = game.hitPlayer().split(":");
                            dealerArray = game.hitDealer().split(":");

                            //checks if either the player or dealer has busted
                            if (game.player.handBust(game.player.lowHandValue)|| game.dealer.handBust(game.dealer.lowHandValue))
                            {
                                //ends the game cause a bust has occurred
                                hitBtn.setEnabled(false);
                                gameResult.setText(game.endGame(game.gameScore()[1], game.gameScore()[0]));
                            }
                            else {
                                //displays the next card for the player
                                int cardFourPlayer = getResources().getIdentifier("@drawable/" + playerArray[3], null, getPackageName());
                                playerCardFour.setImageResource(cardFourPlayer);
                            }
                            //checks if the dealer has busted
                            if (!(dealerArray[0].equals("No Hit")))
                            {
                                //displays the card for the dealer
                                int cardFourDealer = getResources().getIdentifier("@drawable/" + dealerArray[3], null, getPackageName());
                                dealerCardFour.setImageResource(cardFourDealer);
                            }
                            //displays the score
                            score = game.gameScore();
                            playerScore.setText(score[1] + "");
                            dealerScore.setText(score[0] + "");
                            playerCardNumber++;
                        }
                        else if (playerCardNumber == 5)
                        {
                            playerArray = game.hitPlayer().split(":");
                            dealerArray = game.hitDealer().split(":");

                            if (game.player.handBust(game.player.lowHandValue)|| game.dealer.handBust(game.dealer.lowHandValue))
                            {
                                hitBtn.setEnabled(false);

                                gameResult.setText(game.endGame(game.gameScore()[1], game.gameScore()[0]));
                            }
                            else {
                                int cardFivePlayer = getResources().getIdentifier("@drawable/" + playerArray[4], null, getPackageName());
                                playerCardFive.setImageResource(cardFivePlayer);
                            }
                            if (!(dealerArray[0].equals("No Hit")))
                            {
                                int cardFiveDealer = getResources().getIdentifier("@drawable/" + dealerArray[4], null, getPackageName());
                                dealerCardFive.setImageResource(cardFiveDealer);
                            }
                            playerCardNumber++;
                            score = game.gameScore();
                            playerScore.setText(score[1] + "");
                            dealerScore.setText(score[0] + "");
                            hitBtn.setEnabled(false);
                            gameResult.setText(game.endGame(game.gameScore()[1], game.gameScore()[0]) + "");
                        }

                    }
                });

                /**
                 * Instructions for the functionality of the stay button
                 */
                stayBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //disables the hit button
                        hitBtn.setEnabled(false);
                        //score of the dealer and player
                        int score[];

                        //string of the dealers hand
                        String dealerHand[] = new String[1];
                        int dealerHandAmount = 3;

                        //repeats dealing of card until bust or card limit reached
                      while(dealerHandAmount <=5 || !(dealerHand[0].equals("No Hit"))) {
                          dealerHand = game.hitDealer().split(":");

                          //instructions for displaying the third dealer card
                          if (dealerHandAmount == 3) {
                              if (!(dealerHand[0].equals("No Hit"))) {
                                  //display the third dealer card
                                  int cardThreeDealer = getResources().getIdentifier("@drawable/" + dealerHand[2], null, getPackageName());
                                  dealerCardThree.setImageResource(cardThreeDealer);
                              }

                          }
                          //instructions for playing the fourth dealer card
                          else if (dealerHandAmount == 4) {
                              if (!(dealerHand[0].equals("No Hit"))) {
                                  //displaying the fourth dealer card
                                  int cardFourDealer = getResources().getIdentifier("@drawable/" + dealerHand[3], null, getPackageName());
                                  dealerCardFour.setImageResource(cardFourDealer);
                              }

                          }
                          //instruction for playing the fifth dealer card
                          else if (dealerHandAmount == 5) {
                              if (!(dealerHand[0].equals("No Hit"))) {
                                  //displaying the fifth dealer card
                                  int cardFiveDealer = getResources().getIdentifier("@drawable/" + dealerHand[4], null, getPackageName());
                                  dealerCardFive.setImageResource(cardFiveDealer);
                              }

                          }
                          dealerHandAmount++;
                      }
                      //diplaying the game score and its result
                      score = game.gameScore();
                       dealerScore.setText(score[0] + "");
                       playerScore.setText(score[1] + "");
                       gameResult.setText(game.endGame(game.gameScore()[1], game.gameScore()[0]) + "");
                    }
                });

                /**
                 * Instructions for the quit button
                 */
                quitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent quitIntent = new Intent(getApplicationContext(), HomeScreen.class);
                        startActivity(quitIntent);
                    }
                });
            }

        });



    }
}

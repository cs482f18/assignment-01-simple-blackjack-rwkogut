package com.example.richie.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    /**
     * instructions for when the app is started
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //connects to GUI button to a variable
        Button playBlackJackBtn = (Button) findViewById(R.id.startGameButton);
        playBlackJackBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * Instructions for when the play blackjack button is pressed
             * @param v the view
             */
            @Override
            public void onClick(View v) {
                Intent blackjackIntent = new Intent(getApplicationContext(), BlackJackScreen.class);
                startActivity(blackjackIntent);
            }
        });


    }





}

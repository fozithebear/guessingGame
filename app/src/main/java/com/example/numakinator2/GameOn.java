package com.example.numakinator2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOn extends AppCompatActivity {

    Button prevActivity;
    Button submitGuess;
    TextView name;
    TextView interval;
    TextView guesses;
    String useName;
    int useInterval;
    int useGuesses;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_on);

        prevActivity = findViewById(R.id.exitButton);
        submitGuess = findViewById(R.id.guessSubmit);

        name = findViewById(R.id.showName);
        interval = findViewById(R.id.showInterval);
        guesses = findViewById(R.id.showGuesses);

        useName = getIntent().getExtras().getString("Name");
        useInterval = getIntent().getExtras().getInt("Interval");
        useGuesses = getIntent().getExtras().getInt("Guesses");

        if(useInterval >= 1000){
            useInterval = 1000;
        }
        if(useGuesses >= 20){
            useGuesses = 20;
        }


        String strInterval = "Chosen Interval: 0 to " + Integer.toString(useInterval);
        String strGuesses = "Starting Guesses: " + Integer.toString(useGuesses);
        String displayName = "Name: " + useName;

        name.setText(displayName);
        interval.setText(strInterval);
        guesses.setText(strGuesses);

        prevActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOn.this, StartScreen.class);

                startActivity(intent);
            }
        });

    }
}

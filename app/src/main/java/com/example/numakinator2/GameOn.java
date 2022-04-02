package com.example.numakinator2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GameOn extends AppCompatActivity {

    Button prevActivity;
    Button submitGuess;
    TextView name;
    TextView interval;
    TextView guessesLeft;
    TextView highOrlow;
    TextView pastGuesses;

    String useName;
    String message;
    int useInterval;
    int useGuesses;
    int number;
    int counter;
    String HorL;
    String hilo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_on);


        prevActivity = findViewById(R.id.exitButton);
        submitGuess = findViewById(R.id.guessSubmit);
        counter = 0;

        name = findViewById(R.id.showName);
        interval = findViewById(R.id.showInterval);
        guessesLeft = findViewById(R.id.guessesLeft);
        highOrlow = findViewById(R.id.hiorlowting);
        pastGuesses = findViewById(R.id.pastGuesses);


        useName = getIntent().getExtras().getString("Name");
        useInterval = getIntent().getExtras().getInt("Interval");
        useGuesses = getIntent().getExtras().getInt("Guesses");




        if(useInterval >= 1000){
            useInterval = 1000;
        }
        if(useGuesses >= 10){
            useGuesses = 10;
        }
        Random r = new Random();
        number = r.nextInt(useInterval+1);


        String strInterval = "Chosen Interval: 0 to " + Integer.toString(useInterval);
        String strGuesses = "Guesses left: " + Integer.toString(useGuesses);
        String displayName = "Name: " + useName;

        name.setText(displayName);
        interval.setText(strInterval);
        guessesLeft.setText(strGuesses);


        prevActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOn.this, StartScreen.class);

                startActivity(intent);
            }
        });

    }
    public void buttonClicked(View v){
        EditText currentGuess = findViewById(R.id.currentGuess);
        message = "Please enter a guess.";
        if(currentGuess.getText().toString().isEmpty()){
            highOrlow.setText(message);
        } else {
            String test = currentGuess.getText().toString();
            int inputGuess = Integer.parseInt(test);

            if(inputGuess>number){
                HorL = "H";
                hilo = "Guess too high.";
            } else if(inputGuess<number){
                HorL = "L";
                hilo = "Guess too low.";
            } else {
                Intent intent = new Intent(GameOn.this, YouWin.class);
                startActivity(intent);
            }


            useGuesses--;
            highOrlow.setText(hilo);
            String strGuesses = "Guesses left: " + Integer.toString(useGuesses);
            guessesLeft.setText(strGuesses);

            String pastGuess =  HorL + " : " + test;

            pastGuesses.setText(pastGuess);


            if(useGuesses == 0){
                Intent intent = new Intent(GameOn.this, YouLose.class);

                intent.putExtra("Answer", number);
                startActivity(intent);
            }
        }

    }
}


package com.example.numakinator2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Scanner;

public class GameOn extends AppCompatActivity {

    Button prevActivity;
    Button submitGuess;
    TextView name;
    TextView interval;
    TextView guesses;
    TextView guessesLeft;
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
        guessesLeft = findViewById(R.id.guessesLeft);

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
        String strGuesses = "Guesses left: " + Integer.toString(useGuesses);
        String displayName = "Name: " + useName;

        name.setText(displayName);
        interval.setText(strInterval);
        guesses.setText(strGuesses);
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

    }
    public class Player{
        private String name;
        private int interval;
        private int guesses;

        public Player(String name, int interval, int guesses) {
            this.name = name;
            this.interval = interval + 1;
            this.guesses = guesses;
        }

        public Player(String name) {
            this.name = name;
            this.interval = 101;
            this.guesses = 10;
        }


        public String getName() {
            return name;

        }

        public int getInterval() {
            return interval;
        }

        public int getGuesses() {
            return guesses;
        }

        private int getRandomNumber(){
            return (int) (Math.random() * (interval));
        }

        public void startGame() {
            HashMap<String, Integer> history = new HashMap<String, Integer>();
            Scanner scanner = new Scanner(System.in);
            int num = getRandomNumber();

            String low = "L";
            String high = "H";
            for (int i = 0; i < guesses; i++) {
                int guess = scanner.nextInt();
                if (guess < num) {
                    history.put(low, guess);
                } else if (guess > num) {
                    history.put(high, guess);
                }

                for (String key : history.keySet()) {
                    String values = history.values().toString();
                    System.out.println(key + " " + values);
                }
            }
        }

    }

}


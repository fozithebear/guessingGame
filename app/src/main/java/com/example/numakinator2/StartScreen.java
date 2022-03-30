package com.example.numakinator2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreen extends AppCompatActivity {

    Button nextActivity;
    Button prevActivity;
    public EditText name;
    public EditText guesses;
    public EditText interval;
    private static String finalName;
    private static int finalGuesses;
    private static int finalInterval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        guesses = (EditText) findViewById(R.id.maxGuesses);
        finalGuesses = Integer.parseInt(guesses.getText().toString());
        interval = (EditText) findViewById(R.id.maxInterval);
        finalInterval = Integer.parseInt(interval.getText().toString());
        name = (EditText) findViewById(R.id.playerName);
        finalName = name.getText().toString();
        nextActivity = (Button) findViewById(R.id.startGame);
        prevActivity = (Button) findViewById(R.id.backButton);

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreen.this, GameOn.class);
                startActivity(intent);
            }
        });

        prevActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreen.this, MainActivity.class);

                startActivity(intent);
            }
        });

    }

    public static String getName() {
        return finalName;
    }

    public static int getGuesses() {
        //String value = guesses.getText().toString();
        return finalGuesses;
    }

    public static int getInterval() {
        //String value = interval.getText().toString();
        return finalInterval;
    }
}

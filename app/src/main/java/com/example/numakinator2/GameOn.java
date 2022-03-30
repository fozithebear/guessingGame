package com.example.numakinator2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOn extends AppCompatActivity {

    Button prevActivity;
    TextView timer;
    String currentName;
    int currentGuesses;
    int currentInterval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_on);
        Timer t = new Timer();
        prevActivity = (Button) findViewById(R.id.exitButton);
        timer = (TextView) findViewById(R.id.test1);
        timer.setText(StartScreen.getName());

        currentName = StartScreen.getName();
        currentGuesses = StartScreen.getGuesses();
        currentInterval = StartScreen.getInterval();



        prevActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOn.this, StartScreen.class);

                startActivity(intent);
            }
        });

    }
}

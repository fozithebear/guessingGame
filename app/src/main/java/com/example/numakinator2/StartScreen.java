package com.example.numakinator2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreen extends AppCompatActivity {

    Button nextActivity;
    Button prevActivity;
    public EditText name;
    public EditText guesses;
    public EditText interval;
    public TextView mssg;
    String message;
    String sendName;
    int sendGuesses;
    int sendInterval;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);


        mssg = findViewById(R.id.errorMssg);
        guesses = (EditText) findViewById(R.id.maxGuesses);
        interval = (EditText) findViewById(R.id.maxInterval);
        name = (EditText) findViewById(R.id.playerName);

        nextActivity = (Button) findViewById(R.id.startGame);
        prevActivity = (Button) findViewById(R.id.backButton);

        message = "Please enter all required fields.";

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartScreen.this, GameOn.class);

                if(guesses.getText().toString().isEmpty()|| interval.getText().toString().isEmpty()|| name.getText().toString().isEmpty()){
                    mssg.setText(message);
                }
                else{
                    sendName = name.getText().toString();
                    sendGuesses = Integer.parseInt(guesses.getText().toString());
                    sendInterval = Integer.parseInt(interval.getText().toString());


                    intent.putExtra("Name", sendName);
                    intent.putExtra("Guesses",sendGuesses);
                    intent.putExtra("Interval", sendInterval);

                    startActivity(intent);
                    finish();
                }
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
}

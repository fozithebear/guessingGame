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
    EditText name;
    EditText guesses;
    EditText interval;
    TextView mssg;
    TextView askName;
    TextView askInterval;
    TextView askGuesses;

    String message;
    String sendName;
    int sendGuesses;
    int sendInterval;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);


        mssg = findViewById(R.id.errorMssg);
        guesses = findViewById(R.id.maxGuesses);
        interval = findViewById(R.id.maxInterval);
        name = findViewById(R.id.playerName);
        askGuesses = findViewById(R.id.askGuesses);
        askName = findViewById(R.id.askName);
        askInterval = findViewById(R.id.askInteval);


        mssg.setTextColor(getResources().getColor(R.color.black));
        askInterval.setTextColor(getResources().getColor(R.color.black));
        askName.setTextColor(getResources().getColor(R.color.black));
        askGuesses.setTextColor(getResources().getColor(R.color.black));
        guesses.setTextColor(getResources().getColor(R.color.black));
        interval.setTextColor(getResources().getColor(R.color.black));
        name.setTextColor(getResources().getColor(R.color.black));


        nextActivity = (Button) findViewById(R.id.startGame);
        prevActivity = (Button) findViewById(R.id.backButton);

        nextActivity.setTextColor(getResources().getColor(R.color.black));
        prevActivity.setTextColor(getResources().getColor(R.color.black));
        nextActivity.setBackgroundColor(getResources().getColor(R.color.white));
        prevActivity.setBackgroundColor(getResources().getColor(R.color.white));

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

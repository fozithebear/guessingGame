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
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        name = (EditText) findViewById(R.id.playerName);
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
}

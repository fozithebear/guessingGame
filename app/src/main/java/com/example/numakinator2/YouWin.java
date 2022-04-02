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

public class YouWin extends AppCompatActivity {
    Button playAgain;
    TextView youWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_win);

        playAgain = findViewById(R.id.playAgain);
        youWin = findViewById(R.id.youWin);


        youWin.setTextColor(getResources().getColor(R.color.black));

        playAgain.setTextColor(getResources().getColor(R.color.black));
        playAgain.setBackgroundColor(getResources().getColor(R.color.white));

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YouWin.this, StartScreen.class);
                startActivity(intent);

            }
        });
    }
}
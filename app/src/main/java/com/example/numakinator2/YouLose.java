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

public class YouLose extends AppCompatActivity {
    Button playAgain;
    int answer;
    TextView showAnswer;
    TextView youLose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lose);

        youLose = findViewById(R.id.youLose);
        playAgain = findViewById(R.id.playAgain);
        showAnswer = findViewById(R.id.showAnswer);

        youLose.setTextColor(getResources().getColor(R.color.black));
        showAnswer.setTextColor(getResources().getColor(R.color.black));
        playAgain.setTextColor(getResources().getColor(R.color.black));
        playAgain.setBackgroundColor(getResources().getColor(R.color.white));


        answer = getIntent().getExtras().getInt("Answer");

        String displayAnswer = "Answer: " + answer;

        showAnswer.setText(displayAnswer);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YouLose.this, StartScreen.class);
                startActivity(intent);

            }
        });
    }
}
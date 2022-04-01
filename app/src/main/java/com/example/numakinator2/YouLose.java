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
    Button playagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lose);

        playagain = findViewById(R.id.playAgain);

        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YouLose.this, StartScreen.class);
                startActivity(intent);

            }
        });
    }
}
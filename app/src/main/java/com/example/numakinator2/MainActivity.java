package com.example.numakinator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button nextActivity;
    TextView title;
    TextView descriptionOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextActivity = (Button) findViewById(R.id.startScreen);
        title = findViewById(R.id.mainTitle);
        descriptionOne = findViewById(R.id.descriptionOne);


        title.setTextColor(getResources().getColor(R.color.black));
        nextActivity.setTextColor(getResources().getColor(R.color.black));
        nextActivity.setBackgroundColor(getResources().getColor(R.color.white));
        descriptionOne.setTextColor(getResources().getColor(R.color.black));
        descriptionOne.setBackgroundColor(getResources().getColor(R.color.yellow));

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartScreen.class);

                startActivity(intent);
            }
        });
    }
}
package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bot = findViewById(R.id.bot);
        ImageView rock = findViewById(R.id.userRock);
        ImageView paper = findViewById(R.id.userPaper);
        ImageView scissor = findViewById(R.id.userScissor);
        result = findViewById(R.id.result);

    }

    // Call method to start game
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void start(View view){

        switch (view.getId()){

            case R.id.userRock:{
                result.setText("Pedra");
                break;
            }

            case R.id.userPaper:{
                result.setText("Papel");
                break;
            }

            case R.id.userScissor:{
                result.setText("Tesoura");
                break;
            }

        }

    }

    public void game(String userChoice){

    }




}
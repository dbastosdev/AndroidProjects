package com.example.jokenpo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ImageView bot;
    String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bot = findViewById(R.id.bot);
        result = findViewById(R.id.result);

    }

    // Call method to start game
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void start(View view){

        switch (view.getId()){

            case R.id.userRock:{
                user = "Pedra";
                game (user);
                break;
            }

            case R.id.userPaper:{
                user = "Papel";
                game (user);
                break;
            }

            case R.id.userScissor:{
                user = "Tesoura";
                game (user);
                break;
            }

        }

    }

    public void game(String userChoice){

        // Change bot image
        int random = new Random().nextInt(3);
        int[] botRandom = {R.drawable.papel, R.drawable.pedra, R.drawable.tesoura};
        bot.setImageResource(botRandom[random]);

        //Game logic
        if (userChoice.equals("Pedra") && botRandom[random] == R.drawable.tesoura) {
            result.setText(R.string.youwin);
        } else if (userChoice.equals("Papel") && botRandom[random] == R.drawable.pedra){
            result.setText(R.string.youwin);
        } else if (userChoice.equals("Tesoura") && botRandom[random] == R.drawable.papel){
            result.setText(R.string.youwin);
        } else if (userChoice.equals("Tesoura") && botRandom[random] == R.drawable.tesoura){
            result.setText(R.string.draw);
        } else if (userChoice.equals("Papel") && botRandom[random] == R.drawable.papel){
            result.setText(R.string.draw);
        } else if (userChoice.equals("Pedra") && botRandom[random] == R.drawable.pedra){
            result.setText(R.string.draw);
        } else{
            result.setText(R.string.youloose);
        }

    }

}
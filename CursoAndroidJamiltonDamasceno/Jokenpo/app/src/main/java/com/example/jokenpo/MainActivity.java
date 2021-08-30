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
    private TextView userPoint;
    private TextView botPoint;
    private TextView textUserPointName;
    private TextView textBotPointName;
    String user;
    int userP = 0;
    int botP = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bot = findViewById(R.id.bot);
        result = findViewById(R.id.result);
        userPoint = findViewById(R.id.textUserPoints);
        botPoint = findViewById(R.id.textBotPoint);
        textUserPointName = findViewById(R.id.textUserPointName);
        textBotPointName = findViewById(R.id.textBotPointName);

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

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    public void game(String userChoice){

        // Change bot image
        int random = new Random().nextInt(3);
        int[] botRandom = {R.drawable.papel, R.drawable.pedra, R.drawable.tesoura};
        bot.setImageResource(botRandom[random]);

        //Game logic
        if (userChoice.equals("Pedra") && botRandom[random] == R.drawable.tesoura) {
            userP ++;
            result.setTextSize(24);
            result.setTextColor(R.color.purple_700);
            result.setText(R.string.result);
            userPoint.setText(""+userP);
            textUserPointName.setVisibility(View.VISIBLE);
            textBotPointName.setVisibility(View.VISIBLE);
            userPoint.setVisibility(View.VISIBLE);
            botPoint.setVisibility(View.VISIBLE);
        } else if (userChoice.equals("Papel") && botRandom[random] == R.drawable.pedra){
            //result.setText(R.string.youwin);
            userP ++;
            result.setTextSize(24);
            result.setTextColor(R.color.purple_700);
            result.setText(R.string.result);
            userPoint.setText(""+userP);
            textUserPointName.setVisibility(View.VISIBLE);
            textBotPointName.setVisibility(View.VISIBLE);
            userPoint.setVisibility(View.VISIBLE);
            botPoint.setVisibility(View.VISIBLE);
        } else if (userChoice.equals("Tesoura") && botRandom[random] == R.drawable.papel){
            userP ++;
            result.setTextSize(24);
            result.setTextColor(R.color.purple_700);
            result.setText(R.string.result);
            userPoint.setText(""+userP);
            textUserPointName.setVisibility(View.VISIBLE);
            textBotPointName.setVisibility(View.VISIBLE);
            userPoint.setVisibility(View.VISIBLE);
            botPoint.setVisibility(View.VISIBLE);
        } else if (userChoice.equals("Tesoura") && botRandom[random] == R.drawable.tesoura){
            result.setTextSize(24);
            result.setTextColor(R.color.purple_700);
            result.setText(R.string.result);
            textUserPointName.setVisibility(View.VISIBLE);
            textBotPointName.setVisibility(View.VISIBLE);
            userPoint.setVisibility(View.VISIBLE);
            botPoint.setVisibility(View.VISIBLE);
        } else if (userChoice.equals("Papel") && botRandom[random] == R.drawable.papel){
            result.setTextSize(24);
            result.setTextColor(R.color.purple_700);
            result.setText(R.string.result);
            textUserPointName.setVisibility(View.VISIBLE);
            textBotPointName.setVisibility(View.VISIBLE);
            userPoint.setVisibility(View.VISIBLE);
            botPoint.setVisibility(View.VISIBLE);
        } else if (userChoice.equals("Pedra") && botRandom[random] == R.drawable.pedra){
            result.setTextSize(24);
            result.setTextColor(R.color.purple_700);
            result.setText(R.string.result);
            textUserPointName.setVisibility(View.VISIBLE);
            textBotPointName.setVisibility(View.VISIBLE);
            userPoint.setVisibility(View.VISIBLE);
            botPoint.setVisibility(View.VISIBLE);
        } else{
            botP++;
            result.setTextSize(24);
            result.setTextColor(R.color.purple_700);
            result.setText(R.string.result);
            botPoint.setText(""+botP);
            textUserPointName.setVisibility(View.VISIBLE);
            textBotPointName.setVisibility(View.VISIBLE);
            userPoint.setVisibility(View.VISIBLE);
            botPoint.setVisibility(View.VISIBLE);
        }

        //Game points
        if(userP >= 3){
            result.setTextSize(40);
            result.setTextColor(R.color.purple_500);
            result.setText(R.string.youwin);
            botPoint.setText("0");
            userPoint.setText("0");
            botP=0;
            userP=0;
            textUserPointName.setVisibility(View.INVISIBLE);
            textBotPointName.setVisibility(View.INVISIBLE);
            userPoint.setVisibility(View.INVISIBLE);
            botPoint.setVisibility(View.INVISIBLE);
            bot.setImageResource(R.drawable.padrao);
        } else if (botP >= 3){
            result.setTextSize(40);
            result.setTextColor(R.color.teal_700);
            result.setText(R.string.youloose);
            botPoint.setText("0");
            userPoint.setText("0");
            botP=0;
            userP=0;
            textUserPointName.setVisibility(View.INVISIBLE);
            textBotPointName.setVisibility(View.INVISIBLE);
            userPoint.setVisibility(View.INVISIBLE);
            botPoint.setVisibility(View.INVISIBLE);
            bot.setImageResource(R.drawable.padrao);
        }

    }

}
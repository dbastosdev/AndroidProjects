package com.example.fuel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity2 extends AppCompatActivity {

    //Declara as variáveis que farão referência às TextViews da segunda Activity
    public TextView textResult1, textResult2, textResult3, textResult4, textResult5;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        // Inicializa as variáveis
        textResult1 = findViewById(R.id.textResult1);
        textResult2 = findViewById(R.id.textResult2);
        textResult3 = findViewById(R.id.textResult3);
        textResult4 = findViewById(R.id.textResult4);
        textResult5 = findViewById(R.id.textResult5);

        // Pega os dados da Main Activity
        Intent intent = getIntent();
        String result1 = intent.getStringExtra(MainActivity.result1);
        String result2 = intent.getStringExtra(MainActivity.result2);
        String result3 = intent.getStringExtra(MainActivity.result3);
        String result4 = intent.getStringExtra(MainActivity.result4);
        String result5 = intent.getStringExtra(MainActivity.result5);

        // Modifica os dados da segunda Activity
        textResult1.setText(result1 + " km/L");
        textResult2.setText("R$ " + result2);
        textResult3.setText(result3 + " km/L");
        textResult4.setText("R$ " + result4);
        textResult5.setText(result5);


    }
}
package com.example.fuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaração de atributos globas da MainActivity
    private EditText autoAlcool;
    private EditText autoGas;
    private EditText alcoolCost;
    private EditText gasCost;
    private Button calculate;
    private TextView result;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acesso aos id's de cada campo da tela do app
        autoAlcool  = findViewById(R.id.autoAlcool);
        autoGas     = findViewById(R.id.autoGas);
        alcoolCost  = findViewById(R.id.alcoolCost);
        gasCost     = findViewById(R.id.gasCost);
        calculate   = findViewById(R.id.calculate);
        result      = findViewById(R.id.result);
        reset       = findViewById(R.id.reset);

        // monitoramento do botão de calcular com chamada aos métodos de cálculo
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                result();
            }
        });

        // monitoramento do botão de reset com chamada ao método
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    //Método para cálculo
    public void calc (){
        result.setText("alterado");
    }

    //Método para exibir resultado
    public void result(){
        result.setText("alterado");
    }

    //Método para reset e recalculo
    public void reset(){
        result.setText("alterado");
    }


}

















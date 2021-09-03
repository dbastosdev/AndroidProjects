package com.example.fuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
                start();
            }
        });

        // monitoramento do botão de reset com chamada ao método
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        // Abre um nova Activity

    }

    //Método para validação de campos
    public void start(){
        if(autoAlcool.getText().toString().equals(null) || autoAlcool.getText().toString().equals("")
          || autoGas.getText().toString().equals(null) || autoGas.getText().toString().equals("")
          || alcoolCost.getText().toString().equals(null) || alcoolCost.getText().toString().equals("")
          || gasCost.getText().toString().equals(null) || gasCost.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Digite todos valores para prosseguir", Toast.LENGTH_SHORT).show();
        } else{
            calc();
        }
    }

    //Método de cálculo
    public void calc (){


        Float alcoolConsumption = Float.parseFloat(autoAlcool.getText().toString());
        Float gasConsumptioon = Float.parseFloat(autoGas.getText().toString());

        Float alcoolPrice = Float.parseFloat(alcoolCost.getText().toString());
        Float gasPrice = Float.parseFloat(gasCost.getText().toString());

        Float percentConsumption = alcoolConsumption / gasConsumptioon;
        Float percentPrice = alcoolPrice / gasPrice;

        result (percentPrice, percentConsumption);


        //Formatador de resultado para duas casas decimais
        //DecimalFormat formatDec = new DecimalFormat();
        //formatDec.setRoundingMode(RoundingMode.UP);
        //result.setText(String.valueOf(formatDec.format(percent)));
    }

    //Método de resultados
    public void result(Float percentPrice, Float percentConsumption){
        if(percentPrice < percentConsumption){
            result.setText("Usar Álcool é vantajoso");
        } else if (percentPrice > percentConsumption){
            result.setText("Usar Gasolina é vantajoso");
        } else{
            result.setText("Usar álcool ou gasolina é indiferente");
        }
    }


    //Método para reset
    public void reset(){
        autoAlcool.setText("");
        autoGas.setText("");
        alcoolCost.setText("");
        gasCost.setText("");
        result.setText("");
    }


}

















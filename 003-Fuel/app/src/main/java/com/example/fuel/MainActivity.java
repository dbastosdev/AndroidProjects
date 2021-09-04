package com.example.fuel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaração de atributos globas da MainActivity
    public EditText autoAlcool;
    public EditText autoGas;
    public EditText alcoolCost;
    public EditText gasCost;
    public Button calculate;
    public TextView result;

    // Variável utilizada na Intent
    public static final String result1 = "cons_Alcool";
    public static final String result2 = "Val_Alcool";
    public static final String result3 = "cons_Gas";
    public static final String result4 = "Val_Gas";
    public static final String result5 = "resultado";


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

        // monitoramento do botão de calcular com chamada aos métodos de cálculo
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

    }

    //Método para validação de campos e chamada do método de cálculo
    public void start(){
        if(autoAlcool.getText().toString().equals(null) || autoAlcool.getText().toString().equals("")
          || autoGas.getText().toString().equals(null) || autoGas.getText().toString().equals("")
          || alcoolCost.getText().toString().equals(null) || alcoolCost.getText().toString().equals("")
          || gasCost.getText().toString().equals(null) || gasCost.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Digite todos valores para prosseguir", Toast.LENGTH_SHORT).show();
        } else{
            calc();
            intent();
        }
    }

    //Método de cálculo
    public void calc (){

        float alcoolConsumption, gasConsumptioon, alcoolPrice, gasPrice, percentConsumption, percentPrice;

        alcoolConsumption = Float.parseFloat(autoAlcool.getText().toString());
        gasConsumptioon = Float.parseFloat(autoGas.getText().toString());

        alcoolPrice = Float.parseFloat(alcoolCost.getText().toString());
        gasPrice = Float.parseFloat(gasCost.getText().toString());

        percentConsumption = alcoolConsumption / gasConsumptioon;
        percentPrice = alcoolPrice / gasPrice;

        result (percentPrice, percentConsumption);

    }

    //Método de resultados
    @SuppressLint("SetTextI18n")
    public void result(Float percentPrice, Float percentConsumption){
        if(percentPrice < percentConsumption){
            result.setText("Usar Álcool é vantajoso");
            result.setVisibility(View.INVISIBLE);
        } else if (percentPrice > percentConsumption){
            result.setText("Usar Gasolina é vantajoso");
            result.setVisibility(View.INVISIBLE);
        } else{
            result.setText("Usar álcool ou gasolina é indiferente");
            result.setVisibility(View.INVISIBLE);
        }

    }

    public void intent(){
        // Abre nova Intent
        Intent intent = new Intent(getApplicationContext(), ResultActivity2.class);

        String alcoolConsumption2, gasConsumptioon2, alcoolPrice2, gasPrice2;

        alcoolConsumption2 = autoAlcool.getText().toString();
        gasConsumptioon2 = autoGas.getText().toString();
        alcoolPrice2 = alcoolCost.getText().toString();
        gasPrice2 = gasCost.getText().toString();

        //Nomeia os dados que serão enviados para outra Activity
        intent.putExtra(result1, alcoolConsumption2 );
        intent.putExtra(result2, alcoolPrice2);
        intent.putExtra(result3, gasConsumptioon2 );
        intent.putExtra(result4, gasPrice2 );
        intent.putExtra(result5, result.getText().toString());
        // Inicializa a outra activity
        startActivity(intent);
    }

}

















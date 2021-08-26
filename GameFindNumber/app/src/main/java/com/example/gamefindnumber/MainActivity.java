package com.example.gamefindnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Criação atributos com os componentes da interface
    private EditText player1;
    private EditText player2;
    private TextView botPlayer;
    private TextView winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criação de variáveis linkado com o id da tela
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        botPlayer = findViewById(R.id.botPlayer);
        winner = findViewById(R.id.winner);

    }

    // Método chamado pelo evento de click do botão
    public void playGame (View view){

        //Teste de captura de dados da tela
        Integer num1 = Integer.parseInt(player1.getText().toString());
        Integer num2 = Integer.parseInt(player2.getText().toString());
        Integer soma = num1 + num2;

        //Teste de retorno na tela com operação entre os dados capturados na tela
        winner.setText(soma.toString());


    }

}
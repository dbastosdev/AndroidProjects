package com.example.gamefindnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Definição de atributos para serem acessíveis a todos os métodos da MainActivity
    // Esses atributos são criados declarando o tipo do elemento do layout
    private EditText player1;
    private EditText player2;
    private TextView botPlayer;
    private TextView winner;
    private TextView point1;
    private TextView point2;
    private TextView P1;
    private TextView P2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carrega os elementos da tela nos atributos antes da tela ser iniciada
        // Aqui não precisa declarar mais o tipo, só chamar via Id
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        botPlayer = findViewById(R.id.botPlayer);
        winner = findViewById(R.id.winner);
        point1 = findViewById(R.id.pontos1);
        point2 = findViewById(R.id.pontos2);
        P1 = findViewById(R.id.P1);
        P2 = findViewById(R.id.P2);
    }

    int pointP1 = 0;
    int pointP2 = 0;

    // Método chamado pelo evento de click do botão
    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    public void playGame (View view){

        //Captura dos dados digitados na entrada
        // Ou se quisesse já um valor numérico, utilizaria parseInt
        String num1 = player1.getText().toString();
        String num2 = player2.getText().toString();

        //Validação de preenchimento de campos do formulário
        if (num1.equals("") || num2.equals("") || num1.equals(num2)) {
            Toast.makeText(getApplicationContext(),"Digite os valores aceitos para jogar",Toast.LENGTH_SHORT).show();
        } else{

        //Caso os campos estejam preenchidos, lógica do jogo é realizada
            int random  = new Random().nextInt(10);
            botPlayer.setTextColor(R.color.purple_700);
            botPlayer.setTextSize(30);
            botPlayer.setText("Valor do computador: " + random);

            int imput1 = Integer.parseInt(player1.getText().toString());
            int imput2 = Integer.parseInt(player2.getText().toString());

            winner.setTextColor(R.color.teal_200);
            winner.setTextSize(15);
            winner.setVisibility(View.VISIBLE);
            botPlayer.setVisibility(View.VISIBLE);

            if(imput1 == random) {
                winner.setText("O jogador 1 acertou e ganhou!!!");
                winner.setTextSize(30);
                point1.setVisibility(View.INVISIBLE);
                point2.setVisibility(View.INVISIBLE);
                P1.setVisibility(View.INVISIBLE);
                P2.setVisibility(View.INVISIBLE);
            } else if (imput2 == random) {
                winner.setText("O jogador 2 acertou e ganhou!!!");
                winner.setTextSize(30);
                point1.setVisibility(View.INVISIBLE);
                point2.setVisibility(View.INVISIBLE);
                P1.setVisibility(View.INVISIBLE);
                P2.setVisibility(View.INVISIBLE);
            } else if (Math.abs(imput1 - random) < Math.abs(imput2 - random)){
                winner.setText("O jogador 1 ganhou um ponto!");
                pointP1 = pointP1 + 1;
                point1.setText(""+pointP1);
            } else {
                winner.setText("O jogador 2 ganhou um ponto!");
                pointP2 = pointP2 + 1;
                point2.setText(""+pointP2);
            }

        }

    }

    public void reset (View view){
        player1.setText("");
        player2.setText("");
        winner.setVisibility(View.INVISIBLE);
        botPlayer.setVisibility(View.INVISIBLE);
        point1.setVisibility(View.VISIBLE);
        point1.setText("0");
        point2.setVisibility(View.VISIBLE);
        point2.setText("0");
        P1.setVisibility(View.VISIBLE);
        P2.setVisibility(View.VISIBLE);
        winner.setTextSize(15);

        pointP1 = 0;
        pointP2 = 0;
    }


}
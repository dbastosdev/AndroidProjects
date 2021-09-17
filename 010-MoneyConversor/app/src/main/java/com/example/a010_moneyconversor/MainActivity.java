/*
* https://square.github.io/retrofit/
* 0- Adicionar dependencia Retrofit em build.gradle (module) - cliente HTPPS;
* 1- Adicionar dependencia Gson em build.gradle (module) - conversor;
* 2- Layout
* 3- atributos e id's
* 4- atributos e id Retrofit
* 5- Configurar a biblioteca Retrofit e Gson no onCreate;
* 6- Adicionar em manifest permissão de internet;
* 7- Cria método que será chamado pelo botão e retornará resultado para o usuário;
* 8- Criar dois packages: API(interface) e Model dentro de java para ajudar na organização. Será usada para
* implementar a interface necessária para uso da Retrofit. Dentro de API cria e configura uma
* interface. Dentro de model cria-se um modelo que define o tipo de retorno da chamada do Retrofit
* no model configura-se uma classe com o modelo de retorno aguardado da api consultada.
* 9- Configura o model na interface;
* 10- Configura a interface dentro do método que será chamado pelo botão;
* 11- Reconfigura o MoneyService com o complemento da baseUrl para direcionar a rota chamada pela API.
* 12- complementa o call com verificação.
* */

package com.example.a010_moneyconversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import api.MoneyService;
import model.USDBRL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText valReal;
    private TextView amountBitcoin;
    private Button btnConvert;
    private TextView bitcoinValue;
    private TextView date;


    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valReal = findViewById(R.id.valReal);
        amountBitcoin = findViewById(R.id.amountBitcoin);
        btnConvert = findViewById(R.id.btnConvert);
        bitcoinValue = findViewById(R.id.bitcoinValue);
        date = findViewById(R.id.date);


        //Configuração da retrofit e Gson
        retrofit = new Retrofit.Builder()
                //https://www.mercadobitcoin.com.br/api-doc/
                .baseUrl("https://www.mercadobitcoin.net/api/BTC/day-summary/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callApiMoney();


            }
        });
    }


    private void callApiMoney(){

        //Configura a interface e classe de modelo definida anteriormente
        MoneyService moneyService = retrofit.create(MoneyService.class);
        Call <USDBRL> call = moneyService.callMoney();

        //Chama método assíncrono da biblioteca para fazer as chamadas na API
        call.enqueue(new Callback<USDBRL>() {
            @Override
            public void onResponse(Call<USDBRL> call, Response<USDBRL> response) {
                //Verifica se o resultado foi recuperado adequadamente
                if(response.isSuccessful()){
                    USDBRL money = response.body();
                    Double real =  Double.parseDouble(valReal.getText().toString());
                    Double bitcoinReal =  money.getAvg_price();
                    Double totalBitcoin = real / bitcoinReal;


                    amountBitcoin.setText(totalBitcoin + " BTC");
                    date.setText("Data: " + money.getDate());
                    bitcoinValue.setText("1 bitcoin hoje = R$" + money.getAvg_price());

                }
            }

            @Override
            public void onFailure(Call<USDBRL> call, Throwable t) {

            }
        });

    }



}
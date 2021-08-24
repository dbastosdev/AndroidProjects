package com.example.bin2dec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Aqui entra um método para eventos do botão e conversão
    public void convert (View view){
        // Faz o mapeamento do campo de entrada
        EditText bin = findViewById(R.id.binary_field);
        // pega a entrada do usuário
        String convert = bin.getEditableText().toString();
        // Faz conversão para decimal
        int finalConvert = Integer.parseInt(convert,2);
        //Faz o mapeamento da saída e exibe resultado
        TextView result = findViewById(R.id.result);
        result.setText(String.valueOf(finalConvert));
    }

}
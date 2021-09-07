package com.example.a005_tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    // Muita atenção aqui. Os campos dentro de TextInputLayoyt devem ser declarados como EditText
    public EditText totalValue;
    public EditText totalPeople;
    public TextView totalTip;
    public SeekBar seekBar;
    public TextView tip;
    public TextView totalAccount;
    public TextView splitMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalValue = findViewById(R.id.totalValue);
        totalPeople = findViewById(R.id.totalPeople);
        totalTip = findViewById(R.id.totalTip);
        seekBar = findViewById(R.id.seekBar);
        tip = findViewById(R.id.tip);
        totalAccount = findViewById(R.id.totalAccount);
        splitMoney = findViewById(R.id.splitMoney);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                totalTip.setText(progress+"%");
                calc(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calc(Integer progress){

            Float account = Float.parseFloat(totalValue.getText().toString());
            Integer people = Integer.parseInt(totalPeople.getText().toString());

            Float tipValue = (account * progress)/100;
            Float amountMoney = tipValue + account;
            Float amountMoney4People = amountMoney / people;

            tip.setText("R$ "+tipValue);
            totalAccount.setText("R$ "+amountMoney);
            splitMoney.setText("R$ "+amountMoney4People);

    }



}
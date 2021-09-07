package com.example.a006_homecleaning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    public ImageView btnMenu;
    public Button btnQuit;
    public ConstraintLayout menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnMenu = findViewById(R.id.btnMenu);
        btnQuit = findViewById(R.id.btnQuit);
        menu = findViewById(R.id.menu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuAction();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    Integer control = 0;
    public void menuAction(){
        if(control == 0){
            menu.animate().setDuration(500).translationY(0);
            control = 1;
            btnMenu.setBackgroundResource(R.drawable.menu_close);
        }else{
            menu.animate().setDuration(500).translationY(2000);
            control = 0;
            btnMenu.setBackgroundResource(R.drawable.menu_open);
        }
    }

}
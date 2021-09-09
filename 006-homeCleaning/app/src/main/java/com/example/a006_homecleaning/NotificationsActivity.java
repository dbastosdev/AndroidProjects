package com.example.a006_homecleaning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NotificationsActivity extends AppCompatActivity {

    public ImageView btnMenu;
    public ConstraintLayout menu;
    public Button btnHome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        btnMenu = findViewById(R.id.btnMenu);
        menu = findViewById(R.id.menu);
        btnHome = findViewById(R.id.btnHome);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuAction();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHome = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(goHome);
                menuAction();
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
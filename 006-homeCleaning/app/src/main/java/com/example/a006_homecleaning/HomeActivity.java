package com.example.a006_homecleaning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    public ConstraintLayout menu;
    public ImageView btnMenu;
    public Button btnHome;
    public Button btnNotifications;
    public Button btnBookings;
    public Button btnPlan;
    public Button btnAdresses;
    public Button btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnMenu = findViewById(R.id.btnMenu);
        btnQuit = findViewById(R.id.btnQuit);
        menu = findViewById(R.id.menu);
        btnHome = findViewById(R.id.btnHome);
        btnNotifications = findViewById(R.id.btnNotifications);
        btnBookings = findViewById(R.id.btnBookings);
        btnPlan = findViewById(R.id.btnPlans);
        btnAdresses = findViewById(R.id.btnAdresses);


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuAction();
            }
        });


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuAction();
            }
        });

        btnNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goNotifications = new Intent(getApplicationContext(), NotificationsActivity.class);
                startActivity(goNotifications);
                menuAction();

            }
        });

       btnBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBookings = new Intent(getApplicationContext(), BookingsActivity.class);
                startActivity(goBookings);
                menuAction();
            }
        });

        btnPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goPlan = new Intent(getApplicationContext(), PlansActivity.class);
                startActivity(goPlan);
                menuAction();

            }
        });

        btnAdresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goAdresses = new Intent(getApplicationContext(), AdressesActivity.class);
                startActivity(goAdresses);
                menuAction();

            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goQuit = new Intent(getApplicationContext(), QuitActivity.class);
                startActivity(goQuit);
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
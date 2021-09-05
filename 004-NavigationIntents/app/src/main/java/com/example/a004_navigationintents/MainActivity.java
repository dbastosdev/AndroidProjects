package com.example.a004_navigationintents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public ImageView buttonMenu;
    public Button btnExplore;
    public LinearLayout menu;
    public RelativeLayout explorePage;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMenu = findViewById(R.id.btnMenu);
        btnExplore = findViewById(R.id.explorePage);
        menu = findViewById(R.id.mainMenu);
        explorePage = findViewById(R.id.exploreMenu);

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menu.animate().translationX(0);
                explorePage.animate().translationX(0);

            }
        });

        btnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menu.animate().translationX(-750);
                explorePage.animate().translationX(-650);

            }
        });



    }
}
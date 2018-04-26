package com.example.opilane.orienteerumisapp;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    TextView legend;
    Button aita, kompass;
    ImageView signs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        legend = findViewById(R.id.kaardilegend);
        aita = findViewById(R.id.aita);
        kompass = findViewById(R.id.kompass);
        signs = findViewById(R.id.märgidPic);

        aita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AitaActivity.class));

            }
        });
        kompass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KompassActivity.class));
            }
        });
    }

    }




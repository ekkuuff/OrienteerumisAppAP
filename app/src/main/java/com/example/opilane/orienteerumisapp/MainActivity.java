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
    ImageView märgid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        legend = findViewById(R.id.kaardilegend);
        aita = findViewById(R.id.aita);
        kompass = findViewById(R.id.kompass);
        märgid = findViewById(R.id.märgidPic);
    }

    public void aita(View view) {
        aita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AitaActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }


    public void kompass(View view) {
        kompass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KompassActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

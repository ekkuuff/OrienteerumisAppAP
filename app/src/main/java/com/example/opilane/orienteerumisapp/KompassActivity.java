package com.example.opilane.orienteerumisapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class KompassActivity extends AppCompatActivity {

    private ImageView kompassPilt;
    TextView suund;
    private static SensorManager sensorService;
    private Sensor sensor;
    private float algsedKraadid = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompass);

        kompassPilt = findViewById(R.id.kompassPic);
        suund = findViewById(R.id.nurk);

        sensorService = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if (sensor != null) {
            sensorService.registerListener(mySensorEventListener, sensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
            Log.i("Compass MainActivity", "Registerered for ORIENTATION Sensor");
        } else {
            Log.e("Compass MainActivity", "Registerered for ORIENTATION Sensor error");
            Toast.makeText(this, "ORIENTATION Sensor not found",
                    Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // angle between the magnetic north direction
            // 0=North, 90=East, 180=South, 270=West
            float azimuth = event.values[0];
            Log.i("Compass MainActivity", "Azimu " + azimuth);
            float kraadinurk = Math.round(azimuth);
            RotateAnimation pöörlemisAnimatsioon = new RotateAnimation(algsedKraadid,-kraadinurk,
                    Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            // defineerime animatsiooni kestvuse
            pöörlemisAnimatsioon.setDuration(200);
            pöörlemisAnimatsioon.setFillAfter(true);
            kompassPilt.startAnimation(pöörlemisAnimatsioon);
            //salvestame uued kraadid algsete asemel
            algsedKraadid =-kraadinurk;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensor != null) {
            sensorService.unregisterListener(mySensorEventListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}

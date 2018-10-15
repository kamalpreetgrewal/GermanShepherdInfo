package com.example.guestaccount.germanshepherd;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InfoActivity1 extends GestureInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);
    }

    public void nextActivity() {
        Intent intent = new Intent(InfoActivity1.this, InfoActivity2.class);
        startActivity(intent);
    }

    public void prevActivity() {
        Toast.makeText(getApplicationContext(), "This is the first type",
                Toast.LENGTH_SHORT).show();
    }
}

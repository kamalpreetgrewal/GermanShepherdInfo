package com.example.guestaccount.germanshepherd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InfoActivity2 extends GestureInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);
    }

    public void nextActivity() {
        Intent intent = new Intent(InfoActivity2.this, InfoActivity3.class);
        startActivity(intent);
    }

    public void prevActivity() {
        Intent intent = new Intent(InfoActivity2.this, InfoActivity1.class);
        startActivity(intent);
    }
}

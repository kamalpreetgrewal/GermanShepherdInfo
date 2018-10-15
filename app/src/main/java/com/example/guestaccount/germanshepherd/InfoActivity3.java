package com.example.guestaccount.germanshepherd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InfoActivity3 extends GestureInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info3);
    }

    public void nextActivity() {
        Toast.makeText(getApplicationContext(), "This is the last type",
                Toast.LENGTH_SHORT).show();
    }

    public void prevActivity() {
        Intent intent = new Intent(InfoActivity3.this, InfoActivity2.class);
        startActivity(intent);
    }
}

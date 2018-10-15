package com.example.guestaccount.germanshepherd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Fetch views from layout file and initialise the variables with these views.
         */
        Button info1 = (Button) findViewById(R.id.button);
        Button info2 = (Button) findViewById(R.id.button2);
        Button info3 = (Button) findViewById(R.id.button3);

        /**
         * Show image for first type on clicking the button. Set the visibility of description to
         * invisible and only show the image. So on for the other buttons.
         */
        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoActivity1.class);
                intent.putExtra("image", true);
                intent.putExtra("description", false);
                startActivity(intent);
            }
        });

        /**
         * Show description for first type on clicking the button. Set the visibility of image to
         * invisible and only show the text. So on for long clicks for the other buttons.
         */
        info1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity1.class);
                intent.putExtra("image", false);
                intent.putExtra("description", true);
                startActivity(intent);
                return true;
            }
        });

        /**
         * Show image for first type on clicking the button.
         */
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoActivity2.class);
                intent.putExtra("image", true);
                intent.putExtra("description", false);
                startActivity(intent);
            }
        });

        /**
         * Show description for second type on clicking the button.
         */
        info2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity2.class);
                intent.putExtra("image", false);
                intent.putExtra("description", true);
                startActivity(intent);
                return true;
            }
        });

        /**
         * Show image for third type on clicking the button.
         */
        info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoActivity3.class);
                intent.putExtra("image", true);
                intent.putExtra("description", false);
                startActivity(intent);
            }
        });

        /**
         * Show description for the third type on clicking the button.
         */
        info3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity3.class);
                intent.putExtra("image", false);
                intent.putExtra("description", true);
                startActivity(intent);
                return true;
            }
        });
    }
}
package com.example.guestaccount.germanshepherd;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity1 extends GestureInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);

        ImageView imageView = (ImageView) findViewById(R.id.black_shepherd);
        TextView textView = (TextView) findViewById(R.id.black_shepherd_info);

        /**
         * Check the boolean flag from intent depending if it is click or a long-click and set the
         * visibility of image and description accordingly.
         */
        Intent intent = getIntent();
        if (intent.getBooleanExtra("image", false)) {
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
        }
        if (intent.getBooleanExtra("description", false)) {
            imageView.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * This function opens the next activity when user swipes from right to left.
     */
    public void nextActivity() {
        Intent intent = new Intent(InfoActivity1.this, InfoActivity2.class);
        startActivity(intent);
    }

    /**
     * This function opens the next activity when user swipes from left to right.
     */
    public void prevActivity() {
        Toast.makeText(getApplicationContext(), "This is the first type",
                Toast.LENGTH_SHORT).show();
    }
}
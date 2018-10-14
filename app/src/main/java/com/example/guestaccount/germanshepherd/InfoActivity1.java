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

public class InfoActivity1 extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat mDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);

        mDetectorCompat = new GestureDetectorCompat(this, this);

        Button prevButton = (Button) findViewById(R.id.prev_button1);
        Button nextButton = (Button) findViewById(R.id.next_button1);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevActivity();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDetectorCompat.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2,
                           float velocityX, float velocityY) {
        if (motionEvent1.getY() - motionEvent2.getY() > 40 &&
                Math.abs(motionEvent1.getX() - motionEvent2.getX()) < (motionEvent1.getY() - motionEvent2.getY())) {
            // Up
            Toast.makeText(InfoActivity1.this, "You swiped up", Toast.LENGTH_SHORT).show();
        }
        if (motionEvent2.getY() - motionEvent1.getY() > 40 &&
                Math.abs(motionEvent1.getX() - motionEvent2.getX()) < (motionEvent2.getY() - motionEvent1.getY())) {
            // Down
            Toast.makeText(InfoActivity1.this, "You swiped down", Toast.LENGTH_SHORT).show();
        }
        if (motionEvent1.getX() - motionEvent2.getX() > 40 &&
                Math.abs(motionEvent1.getY() - motionEvent2.getY()) < (motionEvent1.getX() - motionEvent2.getX())) {
            // Left
//            Toast.makeText(InfoActivity1.this, "You swiped right", Toast.LENGTH_SHORT).show();
            nextActivity();
        }
        if (motionEvent2.getX() - motionEvent1.getX() > 40 &&
                Math.abs(motionEvent1.getY() - motionEvent2.getY()) < (motionEvent2.getX() - motionEvent1.getX())) {
            // Right
//            Toast.makeText(InfoActivity1.this, "You swiped left", Toast.LENGTH_SHORT).show();
            prevActivity();
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Toast.makeText(InfoActivity1.this, "Long press", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
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

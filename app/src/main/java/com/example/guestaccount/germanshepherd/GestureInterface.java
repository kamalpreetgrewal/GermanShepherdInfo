package com.example.guestaccount.germanshepherd;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;

public class GestureInterface extends AppCompatActivity implements  GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat mDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetectorCompat = new GestureDetectorCompat(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDetectorCompat.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    /**
     * This method helps to identify the direction of swipe. The path swiped across one of the axes
     * is compared with the path swiped across the other to identify where motion is more. For instance
     * if the motion is a little slanting, the behavior of swipe is ambiguous, hence the comparison
     * is done.
     * @param motionEvent1
     * @param motionEvent2
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2,
                           float velocityX, float velocityY) {
        if (motionEvent1.getY() - motionEvent2.getY() > 40 &&
                Math.abs(motionEvent1.getX() - motionEvent2.getX()) < (motionEvent1.getY() - motionEvent2.getY())) {
            // Up
//            Toast.makeText(this, "You swiped up", Toast.LENGTH_SHORT).show();
            homeActivity();
        } else if (motionEvent2.getY() - motionEvent1.getY() > 40 &&
                Math.abs(motionEvent1.getX() - motionEvent2.getX()) < (motionEvent2.getY() - motionEvent1.getY())) {
            // Down
            Toast.makeText(this, "You swiped down", Toast.LENGTH_SHORT).show();
        }
        if (motionEvent1.getX() - motionEvent2.getX() > 40 &&
                Math.abs(motionEvent1.getY() - motionEvent2.getY()) < (motionEvent1.getX() - motionEvent2.getX())) {
            // Left
//            Toast.makeText(InfoActivity1.this, "You swiped right", Toast.LENGTH_SHORT).show();
            nextActivity();
        } else if (motionEvent2.getX() - motionEvent1.getX() > 40 &&
                Math.abs(motionEvent1.getY() - motionEvent2.getY()) < (motionEvent2.getX() - motionEvent1.getX())) {
            // Right
//            Toast.makeText(InfoActivity1.this, "You swiped left", Toast.LENGTH_SHORT).show();
            prevActivity();
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Toast.makeText(this, "Long press", Toast.LENGTH_SHORT).show();
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

    /**
     * These methods are overridden in specific activities for navigation.
     */
    public void nextActivity() {
    }

    public void prevActivity() {
    }

    /**
     * This method takes the user to home activity when swiped bottom to up.
     */
    public void homeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

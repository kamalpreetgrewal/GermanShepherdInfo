package com.example.guestaccount.germanshepherd;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class GestureInterface implements View.OnTouchListener {

    private GestureDetectorCompat mDetectorCompat;
    private Context mContext;

    /**
     * The constructor gets the context from the corresponding fragment and helps with swipe gestures.
     * @param context
     */
    public GestureInterface(Context context) {
        mContext = context;
        mDetectorCompat = new GestureDetectorCompat(mContext, new GestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (this.mDetectorCompat.onTouchEvent(event)) {
            return true;
        }
        return mDetectorCompat.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
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
                    Math.abs(motionEvent1.getX() - motionEvent2.getX()) <
                            (motionEvent1.getY() - motionEvent2.getY())) {
                // Up
                Toast.makeText(mContext, "You swiped up", Toast.LENGTH_SHORT).show();
                homeActivity();
            } else if (motionEvent2.getY() - motionEvent1.getY() > 40 &&
                    Math.abs(motionEvent1.getX() - motionEvent2.getX()) <
                            (motionEvent2.getY() - motionEvent1.getY())) {
                // Down
                Toast.makeText(mContext, "You swiped down", Toast.LENGTH_SHORT).show();
            }
            if (motionEvent1.getX() - motionEvent2.getX() > 40 &&
                    Math.abs(motionEvent1.getY() - motionEvent2.getY()) <
                            (motionEvent1.getX() - motionEvent2.getX())) {
                // Left
                nextActivity();
            } else if (motionEvent2.getX() - motionEvent1.getX() > 40 &&
                    Math.abs(motionEvent1.getY() - motionEvent2.getY()) <
                            (motionEvent2.getX() - motionEvent1.getX())) {
                // Right
                prevActivity();
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
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
            return true;
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
    }

    /**
     * These methods are overridden in specific fragments for changing information on swiping.
     */
    public void nextActivity() {
    }

    public void prevActivity() {
    }

    /**
     * This method takes the user to home activity when swiped bottom to up.
     */
    public void homeActivity() {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }
    }

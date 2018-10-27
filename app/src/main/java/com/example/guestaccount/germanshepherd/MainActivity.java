package com.example.guestaccount.germanshepherd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Create a default fragment first and set the layout of the activity. This fragment is
         * changed depending on the button clicked or on navigation between the info fragments.
         */
        final FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new DefaultFragment();
        fragmentManager.beginTransaction().replace(R.id.info_fragment, fragment).commit();
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Swipe from bottom to top in the image when it shows to go " +
                "to main screen.", Toast.LENGTH_LONG).show();

        /**
         * Fetch views from layout file and initialise the variables with these views.
         */
        Button info1 = findViewById(R.id.button);
        Button info2 = findViewById(R.id.button2);
        Button info3 = findViewById(R.id.button3);

        /**
         * Show the fragment 1 on clicking first button.
         */
        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new InfoFragment1();
                fragmentManager.beginTransaction().replace(R.id.info_fragment, fragment).commit();
            }
        });

        /**
         * Show fragment 2 on clicking this button.
         */
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new InfoFragment2();
                fragmentManager.beginTransaction().replace(R.id.info_fragment, fragment).commit();
            }
        });

        /**
         * Show image for fragment 2 on clicking this button.
         */
        info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new InfoFragment3();
                fragmentManager.beginTransaction().replace(R.id.info_fragment, fragment).commit();
            }
        });
    }
}
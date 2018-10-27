package com.example.guestaccount.germanshepherd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoFragment2 extends Fragment {

    /**
     * Inflate this fragment and using GestureInterface class, change the content in the container
     * fragment on swiping left/right.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_info2, container, false);

        ImageView imageView = view.findViewById(R.id.black_tan_shepherd);
        TextView textView = view.findViewById(R.id.black_tan_shepherd_info);

        imageView.setOnTouchListener(new GestureInterface(getActivity().getApplicationContext()){
            FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
            public void nextActivity() {
                Fragment fragment = new InfoFragment3();
                mFragmentManager.beginTransaction().replace(R.id.info_fragment, fragment).commit();
            }
            public void prevActivity() {
                Fragment fragment = new InfoFragment1();
                mFragmentManager.beginTransaction().replace(R.id.info_fragment, fragment).commit();
            }
        });

        return view;
    }
}

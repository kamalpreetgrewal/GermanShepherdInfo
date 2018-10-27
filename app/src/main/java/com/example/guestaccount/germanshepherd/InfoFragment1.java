package com.example.guestaccount.germanshepherd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoFragment1 extends Fragment {

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
        final View view = inflater.inflate(R.layout.fragment_info1, container, false);

        ImageView imageView = view.findViewById(R.id.black_shepherd);
        TextView textView = view.findViewById(R.id.black_shepherd_info);

        imageView.setOnTouchListener(new GestureInterface(getActivity().getApplicationContext()){
            FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
            public void nextActivity() {
                Fragment fragment = new InfoFragment2();
                mFragmentManager.beginTransaction().replace(R.id.info_fragment, fragment).commit();
            }
            public void prevActivity() {
                Toast.makeText(getActivity(), "This is the first type, no previous items.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
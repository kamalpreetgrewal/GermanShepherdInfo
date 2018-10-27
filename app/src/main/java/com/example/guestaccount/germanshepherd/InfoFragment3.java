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

public class InfoFragment3 extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_info3, container, false);

        ImageView imageView = view.findViewById(R.id.white_shepherd);
        TextView textView = view.findViewById(R.id.white_shepherd_info);

        imageView.setOnTouchListener(new GestureInterface(getActivity().getApplicationContext()){
            FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
            public void nextActivity() {
                Toast.makeText(getActivity(), "This is the last type, no next items.",
                        Toast.LENGTH_SHORT).show();
            }
            public void prevActivity() {
                Fragment fragment = new InfoFragment2();
                mFragmentManager.beginTransaction().replace(R.id.info_fragment, fragment).commit();
            }
        });

        return view;
    }
}

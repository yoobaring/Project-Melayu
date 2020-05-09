package com.example.melayu.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.melayu.R;
import com.example.melayu.StartingScreen1Activity;
import com.example.melayu.StartingScreen2Activity;
import com.example.melayu.StartingScreenActivity;
import com.example.melayu.StartingScreenActivityS;

/**
 * A simple {@link Fragment} subclass.
 */
public class TalkFragment extends Fragment {
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;

    public TalkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_talk, container, false);

        imageButton1 = v.findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivityS.class);
                startActivity(intent);
            }
        });

        imageButton2 = v.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreen1Activity.class);
                startActivity(intent);
            }
        });

        imageButton3 = v.findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreen2Activity.class);
                startActivity(intent);
            }
        });

        imageButton4 = v.findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreen2Activity.class);
                startActivity(intent);
            }
        });
//
        imageButton5 = v.findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreen1Activity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}

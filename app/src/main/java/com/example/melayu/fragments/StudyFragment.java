package com.example.melayu.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.melayu.R;
import com.example.melayu.StartingScreen1Activity;
import com.example.melayu.StartingScreen2Activity;
import com.example.melayu.StartingScreen3Activity;
import com.example.melayu.StartingScreen4Activity;
import com.example.melayu.StartingScreen5Activity;
import com.example.melayu.StartingScreenActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private ImageButton imageButton8;
    private ImageButton imageButton9;
    private ImageButton imageButton10;
    private ImageButton imageButton11;
    private ImageButton imageButton12;

    public StudyFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_study, container, false);

        imageButton1 = v.findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
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

                Intent intent = new Intent(getActivity(), StartingScreen3Activity.class);
                startActivity(intent);
            }
        });
//
        imageButton5 = v.findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreen4Activity.class);
                startActivity(intent);
            }
        });

        imageButton6 = v.findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreen5Activity.class);
                startActivity(intent);
            }
        });

        imageButton7 = v.findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });

        imageButton8 = v.findViewById(R.id.imageButton8);
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });

        imageButton9 = v.findViewById(R.id.imageButton9);
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });

        imageButton10 = v.findViewById(R.id.imageButton10);
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });
        imageButton11 = v.findViewById(R.id.imageButton11);
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });

        imageButton12 = v.findViewById(R.id.imageButton12);
        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }
}


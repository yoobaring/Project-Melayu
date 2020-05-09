package com.example.melayu.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.melayu.R;
import com.example.melayu.StartingScreenActivity;
import com.example.melayu.StartingScreenActivityA;
import com.example.melayu.StartingScreenActivityB;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerdFragment extends Fragment {

    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;

    public VerdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_verd, container, false);


        imageView3 = v.findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivityA.class);
                startActivity(intent);
            }
        });
        imageView4 = v.findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivityB.class);
                startActivity(intent);
            }
        });
        imageView5 = v.findViewById(R.id.imageView5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });
        imageView6 = v.findViewById(R.id.imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });
        imageView7 = v.findViewById(R.id.imageView7);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });
        imageView8 = v.findViewById(R.id.imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });
        imageView9 = v.findViewById(R.id.imageView9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });
        imageView10 = v.findViewById(R.id.imageView10);
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), StartingScreenActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }
}

package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class page2 extends AppCompatActivity {
    ImageView a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        a1=(ImageView) findViewById(R.id.imageView1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a1 = new Intent(page2.this,page2_1.class);
                startActivity(a1);
            }
        });

        a2=(ImageView) findViewById(R.id.imageView2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a2 = new Intent(page2.this,page2_2.class);
                startActivity(a2);
            }
        });

        a3=(ImageView) findViewById(R.id.imageView3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a3 = new Intent(page2.this,page2_3.class);
                startActivity(a3);
            }
        });

        a4=(ImageView) findViewById(R.id.imageView4);
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a4 = new Intent(page2.this,page2_4.class);
                startActivity(a4);
            }
        });

        a5=(ImageView) findViewById(R.id.imageView5);
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a5 = new Intent(page2.this,page2_5.class);
                startActivity(a5);
            }
        });

        a2=(ImageView) findViewById(R.id.imageView2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a2 = new Intent(page2.this,page2_2.class);
                startActivity(a2);
            }
        });

        a6=(ImageView) findViewById(R.id.imageView6);
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a6 = new Intent(page2.this,page2_6.class);
                startActivity(a6);
            }
        });

        a7=(ImageView) findViewById(R.id.imageView7);
        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a7 = new Intent(page2.this,page2_7.class);
                startActivity(a7);
            }
        });

        a8=(ImageView) findViewById(R.id.imageView8);
        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a8 = new Intent(page2.this,page2_8.class);
                startActivity(a8);
            }
        });

        a9=(ImageView) findViewById(R.id.imageView9);
        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a9 = new Intent(page2.this,page2_9.class);
                startActivity(a9);
            }
        });

        a10=(ImageView) findViewById(R.id.imageView10);
        a10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a10 = new Intent(page2.this,page2_10.class);
                startActivity(a10);
            }
        });



    }
}

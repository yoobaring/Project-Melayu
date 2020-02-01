package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class page1 extends AppCompatActivity {
     ImageButton v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        v1=(ImageButton) findViewById(R.id.imageButton1);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v1 = new Intent(page1.this,page1_1.class);
                startActivity(v1);
            }
        });

        v2=(ImageButton) findViewById(R.id.imageButton2);
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v2 = new Intent(page1.this,page1_2.class);
                startActivity(v2);
            }
        });

        v3=(ImageButton) findViewById(R.id.imageButton3);
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v3 = new Intent(page1.this,page1_3.class);
                startActivity(v3);
            }
        });

        v4=(ImageButton) findViewById(R.id.imageButton4);
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v4 = new Intent(page1.this,page1_4.class);
                startActivity(v4);
            }
        });

        v5=(ImageButton) findViewById(R.id.imageButton5);
        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v5 = new Intent(page1.this,psge1_5.class);
                startActivity(v5);
            }
        });

        v6=(ImageButton) findViewById(R.id.imageButton6);
        v6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v6 = new Intent(page1.this,page1_6.class);
                startActivity(v6);
            }
        });

        v7=(ImageButton) findViewById(R.id.imageButton7);
        v7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v7 = new Intent(page1.this,page1_7.class);
                startActivity(v7);
            }
        });

        v8=(ImageButton) findViewById(R.id.imageButton8);
        v8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v8 = new Intent(page1.this,page1_8.class);
                startActivity(v8);
            }
        });

        v9=(ImageButton) findViewById(R.id.imageButton9);
        v9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v9 = new Intent(page1.this,page1_9.class);
                startActivity(v9);
            }
        });

        v10=(ImageButton) findViewById(R.id.imageButton10);
        v10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v10 = new Intent(page1.this,page1_10.class);
                startActivity(v10);
            }
        });

        v11=(ImageButton) findViewById(R.id.imageButton11);
        v11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v11 = new Intent(page1.this,page1_11.class);
                startActivity(v11);
            }
        });

        v12=(ImageButton) findViewById(R.id.imageButton12);
        v12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v12 = new Intent(page1.this,page1_12.class);
                startActivity(v12);
            }
        });


    }
}

package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.melayu.R;

public class page3 extends AppCompatActivity {
    ImageButton v1,v2,v3,v4,v5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        v1=(ImageButton) findViewById(R.id.imageButton1);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v1 = new Intent(page3.this,page3_1.class);
                startActivity(v1);
            }
        });

        v2=(ImageButton) findViewById(R.id.imageButton2);
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v2 = new Intent(page3.this,page3_2.class);
                startActivity(v2);
            }
        });

        v3=(ImageButton) findViewById(R.id.imageButton9);
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v3 = new Intent(page3.this,page3_3.class);
                startActivity(v3);
            }
        });

        v4=(ImageButton) findViewById(R.id.imageButton4);
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v4 = new Intent(page3.this,page3_4.class);
                startActivity(v4);
            }
        });

        v5=(ImageButton) findViewById(R.id.imageButton5);
        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v5 = new Intent(page3.this,page3_5.class);
                startActivity(v5);
            }
        });
    }
}

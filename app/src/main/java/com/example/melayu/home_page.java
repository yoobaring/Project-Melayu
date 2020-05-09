package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class home_page extends AppCompatActivity {
    ImageButton p1,p2,p3,p4,p5,p6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        p1=(ImageButton) findViewById(R.id.imageButton1);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p1 = new Intent(home_page.this,page1.class);
                startActivity(p1);
            }
        });

        p2=(ImageButton) findViewById(R.id.imageButton2);
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p2 = new Intent(home_page.this,page2.class);
                startActivity(p2);
            }
        });

        p3=(ImageButton) findViewById(R.id.imageButton3);
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p3 = new Intent(home_page.this,page3.class);
                startActivity(p3);
            }
        });

        p4=(ImageButton) findViewById(R.id.imageButton4);
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p4 = new Intent(home_page.this,page4.class);
                startActivity(p4);
            }
        });

        p5=(ImageButton) findViewById(R.id.imageButton5);
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p5 = new Intent(home_page.this, com.example.melayu.CRUD.PageCRUD.class);
                startActivity(p5);
            }
        });

        p6=(ImageButton) findViewById(R.id.imageButton6);
        p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p6 = new Intent(home_page.this,devolop.class);
                startActivity(p6);
            }
        });
    }
}

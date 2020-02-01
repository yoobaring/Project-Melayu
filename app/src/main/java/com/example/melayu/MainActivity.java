package com.example.melayu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  private static int splash_time = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySupperIntent = new Intent(MainActivity.this ,home_page.class);
                startActivity(mySupperIntent);
                finish();
            }
        },splash_time);

         }
}

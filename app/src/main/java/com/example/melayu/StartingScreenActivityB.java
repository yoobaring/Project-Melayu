package com.example.melayu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartingScreenActivityB extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;

    private int highscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen_b);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadateHighscore();

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        Intent intent = new Intent(StartingScreenActivityB.this, QuizActivityB.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ );

    }
    // เป็นส่วนในการอัพเดตคะแนนของมากที่สุด โดยนำคะแนนเดิมมาเปรียบเทียบคะแนนล่าสุดแล้วถ้าคะแนนไหนมากสุดก็จะแสดงคะแนนนั้น
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivityB.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadateHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("คะแนนสูงสุด: " + highscore);
    }

    // อัพเดตคะแนนสูงสุด เข้าหน้าปัจจุบัน
    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("คะแนนสูงสุด: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}

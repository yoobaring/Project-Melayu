package com.example.melayu;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizActivityS extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<QuestionS> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private QuestionS currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_s);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getLinkTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        if (savedInstanceState == null) {
            QuizDbhelperS dbhelper = new QuizDbhelperS(this);
            questionList = dbhelper.getAllQuestions();
            questionCountTotal = questionList.size();
            Collections.shuffle(questionList);

            showNextQuestion();
        } else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            questionCountTotal = questionList.size();
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentQuestion = questionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);

            if (!answered) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }


        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivityS.this, "กรุณาเลือกคำตอบ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }

            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);


        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("คำถาม: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("ยืนยัน");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();

        }else {
            finishQuiz();
        }
    }

    // แสดงเมื่อตอบช้าแล้วกำหนดว่าจะหมดเวลาภายใน 10 วิ ส่งในฟังก์ชั่น update
    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }


            // เชคว่าเวลาหยุดตรงไหน แล้วเข้าไปเชคคำตอบ เพื่อแสดง
            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();

    }

    // ทำการกำหนดเงื่อนไขว่าเหลืออีก 10 วิ มันจะเป็นสีแดง
    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED); // สีแดง
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    // เชคคำตอบว่าถูกไหม ถ้าถูกบวกคะแนนเพิ่ม
    private void checkAnswer() {
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            textViewScore.setText("คะแนน: " + score);
        }

        showSolution();
    }


    // ในส่วนนี้จะเป็นการโชว์ว่า เมื่อหมดเวลาจะโชว์คำตอบเป้นสีแดง แล้วทำการตรวจคำตอบว่าข้อที่ถูกถ้าใช่จะแสดงข้อที่ถูกเป็นสีเขียว
    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("คำตอบ 1 ถูกต้อง");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("คำตอบ 2 ถูกต้อง");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("คำตอบ 3 ถูกต้อง");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                textViewQuestion.setText("คำตอบ 4 ถูกต้อง");
                break;
        }

        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("ถัดไป");
        } else {
            buttonConfirmNext.setText("จบ");
        }
    }


    // เมื่อทำครบ จะแสดงหน้าคะแนนทั้งหมดที่ตอบถูก
    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    // เป็นส่วนของการกำหนดค่าว่าให้กดปุ่มย้อนกลับอีกครั้งเ เพื่อสิ้นสุด
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "กดอีกครั้งเพื่อสิ้นสุด", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);
    }
}

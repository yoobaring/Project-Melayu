package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuizDbHelper4 extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "MyAwesomeQuiz4.db";
    private static final int DATABASE_VERSION = 6;

    private SQLiteDatabase db;

    public QuizDbHelper4(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE_4= "CREATE TABLE " +
                QuizContract4.QuestionsTable4.TABLE_NAME + " ( " +
                QuizContract4.QuestionsTable4._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract4.QuestionsTable4.COLUMN_QUESTION_4 + " TEXT, " +
                QuizContract4.QuestionsTable4.COLUMN_OPTION1_4 + " TEXT, " +
                QuizContract4.QuestionsTable4.COLUMN_OPTION2_4 + " TEXT, " +
                QuizContract4.QuestionsTable4.COLUMN_OPTION3_4 + " TEXT, " +
                QuizContract4.QuestionsTable4.COLUMN_OPTION4_4 + " TEXT, " +
                QuizContract4.QuestionsTable4.COLUMN_ANSWER_NR_4 + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE_4);
        fillQuestionsTable4();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract4.QuestionsTable4.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable4() {
        Question4 q1 = new Question4("Dia","มีอะไร", "ครับ","เธอ", "นาย", 3);
        addQuestion4(q1);
        Question4 q2 = new Question4("คุณ (ไม่เป็นทางการ","Maafkan saya","Awak","Tidak", "Saya", 2);
        addQuestion4(q2);
        Question4 q3 = new Question4("Itu","นั่น", "สวัสดี", "วันนี้อากาศดีมากน่ะครับ", "ขอให้โชคดี", 1);
        addQuestion4(q3);
        Question4 q4 = new Question4("พวกเขา", "Selamat tinggal", "Boleh saya bantu awak","Sekali lagi", "Mereka", 4);
        addQuestion4(q4);
        Question4 q5 = new Question4("เหล่านี้", "Selamat", "Awak","Sekali","Ini", 4);
        addQuestion4(q5);
        Question4 q6 = new Question4("Saya", "คุณ","ผม","ครับ","ไปก่อนน่ะครับ", 2);
        addQuestion4(q6);



    }
    private void addQuestion4(Question4 question4) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract4.QuestionsTable4.COLUMN_QUESTION_4, question4.getQuestion_4());
        cv.put(QuizContract4.QuestionsTable4.COLUMN_OPTION1_4, question4.getOption1_4());
        cv.put(QuizContract4.QuestionsTable4.COLUMN_OPTION2_4, question4.getOption2_4());
        cv.put(QuizContract4.QuestionsTable4.COLUMN_OPTION3_4, question4.getOption3_4());
        cv.put(QuizContract4.QuestionsTable4.COLUMN_OPTION4_4, question4.getOption4_4());
        cv.put(QuizContract4.QuestionsTable4.COLUMN_ANSWER_NR_4, question4.getAnswerNr_4());
        db.insert(QuizContract4.QuestionsTable4.TABLE_NAME,null, cv);

    }
    public ArrayList<Question4> getAllQuestions4() {
        ArrayList<Question4> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract4.QuestionsTable4.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                Question4 question4 = new Question4();
                question4.setQuestion_4(c.getString(c.getColumnIndex(QuizContract4.QuestionsTable4.COLUMN_QUESTION_4)));
                question4.setOption1_4(c.getString(c.getColumnIndex(QuizContract4.QuestionsTable4.COLUMN_OPTION1_4)));
                question4.setOption2_4(c.getString(c.getColumnIndex(QuizContract4.QuestionsTable4.COLUMN_OPTION2_4)));
                question4.setOption3_4(c.getString(c.getColumnIndex(QuizContract4.QuestionsTable4.COLUMN_OPTION3_4)));
                question4.setOption4_4(c.getString(c.getColumnIndex(QuizContract4.QuestionsTable4.COLUMN_OPTION4_4)));
                question4.setAnswerNr_4(c.getInt(c.getColumnIndex(QuizContract4.QuestionsTable4.COLUMN_ANSWER_NR_4)));
                questionList.add(question4);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}

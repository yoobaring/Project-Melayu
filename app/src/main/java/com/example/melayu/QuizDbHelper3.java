package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuizDbHelper3 extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "MyAwesomeQuiz3.db";
    private static final int DATABASE_VERSION = 7;

    private SQLiteDatabase db;

    public QuizDbHelper3(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE_3= "CREATE TABLE " +
                QuizContract3.QuestionsTable3.TABLE_NAME + " ( " +
                QuizContract3.QuestionsTable3._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract3.QuestionsTable3.COLUMN_QUESTION_3 + " TEXT, " +
                QuizContract3.QuestionsTable3.COLUMN_OPTION1_3 + " TEXT, " +
                QuizContract3.QuestionsTable3.COLUMN_OPTION2_3 + " TEXT, " +
                QuizContract3.QuestionsTable3.COLUMN_OPTION3_3 + " TEXT, " +
                QuizContract3.QuestionsTable3.COLUMN_OPTION4_3 + " TEXT, " +
                QuizContract3.QuestionsTable3.COLUMN_ANSWER_NR_3 + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE_3);
        fillQuestionsTable3();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +QuizContract3.QuestionsTable3.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable3() {
        Question3 q1 = new Question3("ขอโทษนะครับ เมื่อกี้ผมไม่ได้ยินชื่อของคุณครับ","Maaf, saya tak dengar nama awak","Perkataan demi perkataan","Sekali lagi","Jumpa awak nanti",1);
        addQuestion3(q1);
        Question3 q2 = new Question3("Terima kasih","ยินดีตอนรับครับ","คุณพูดภาษาอังกฤษได้ไหมครับ","ขอบคุณครับ ", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion3(q2);
        Question3 q3 = new Question3("ขอให้หายเร็วๆ นะครับ","Maafkan saya","Semoga awak diberkati","Tidak", "Gembira dapat berjumpa awak", 2);
        addQuestion3(q3);
        Question3 q4 = new Question3("ผมมาจากนิวยอร์กครับ", "Selamat tinggal", "Boleh saya bantu awak","Sekali lagi", "Saya dari New York", 4);
        addQuestion3(q4);
        Question3 q5 = new Question3("Gembira bertemu dengan awak", "คุณพูดว่าอะไรน่ะครับ","ยินดีที่ได้พบคุณครับ","มีอะไรให้ช่วยไหมครับ","ไปก่อนน่ะครับ", 2);
        addQuestion3(q5);
        Question3 q6 = new Question3("คุณชื่ออะไร", "Selamat tinggal", "Boleh saya bantu awak","Sekali lagi","Siapa nama awak", 4);
        addQuestion3(q6);
        Question3 q7 = new Question3("Selamat hari jadi", "คุณพูดว่าอะไรน่ะครับ","สุขสันต์วันเกิดนะครับ","มีอะไรให้ช่วยไหมครับ","ไปก่อนน่ะครับ", 2);
        addQuestion3(q7);
        Question3 q8 = new Question3(" Awak dari mana","มีอะไรให้ช่วยไหมครับ", "ยินดีตอนรับครับ","คุณมาจากที่ไหน", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion3(q8);
        Question3 q9 = new Question3("Nama saya Maria", "ฉันชื่อมาเรียค่ะ ", "สวัสดีตอนเช้าครับ", "วันนี้อากาศดีมากน่ะครับ", "ขอให้โชคดีน่ะครับ", 1);
        addQuestion3(q9);
        Question3 q10 = new Question3("ได้โปรด","Boleh", "sedikit", "Silakan"," Awak ada soalan", 3);
        addQuestion3(q10);


    }
    private void addQuestion3(Question3 question3) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract3.QuestionsTable3.COLUMN_QUESTION_3, question3.getQuestion_3());
        cv.put(QuizContract3.QuestionsTable3.COLUMN_OPTION1_3, question3.getOption1_3());
        cv.put(QuizContract3.QuestionsTable3.COLUMN_OPTION2_3, question3.getOption2_3());
        cv.put(QuizContract3.QuestionsTable3.COLUMN_OPTION3_3, question3.getOption3_3());
        cv.put(QuizContract3.QuestionsTable3.COLUMN_OPTION4_3, question3.getOption4_3());
        cv.put(QuizContract3.QuestionsTable3.COLUMN_ANSWER_NR_3, question3.getAnswerNr_3());
        db.insert(QuizContract3.QuestionsTable3.TABLE_NAME,null, cv);

    }
    public ArrayList<Question3> getAllQuestions3() {
        ArrayList<Question3> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " +QuizContract3.QuestionsTable3.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                Question3 question3 = new Question3();
                question3.setQuestion_3(c.getString(c.getColumnIndex(QuizContract3.QuestionsTable3.COLUMN_QUESTION_3)));
                question3.setOption1_3(c.getString(c.getColumnIndex(QuizContract3.QuestionsTable3.COLUMN_OPTION1_3)));
                question3.setOption2_3(c.getString(c.getColumnIndex(QuizContract3.QuestionsTable3.COLUMN_OPTION2_3)));
                question3.setOption3_3(c.getString(c.getColumnIndex(QuizContract3.QuestionsTable3.COLUMN_OPTION3_3)));
                question3.setOption4_3(c.getString(c.getColumnIndex(QuizContract3.QuestionsTable3.COLUMN_OPTION4_3)));
                question3.setAnswerNr_3(c.getInt(c.getColumnIndex(QuizContract3.QuestionsTable3.COLUMN_ANSWER_NR_3)));
                questionList.add(question3);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}

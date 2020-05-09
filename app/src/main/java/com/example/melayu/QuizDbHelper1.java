package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuizDbHelper1 extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "MyAwesomeQuiz1.db";
    private static final int DATABASE_VERSION = 6;

    private SQLiteDatabase db;

    public QuizDbHelper1(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE_1 = "CREATE TABLE " +
                QuizContract1.QuestionsTable1.TABLE_NAME + " ( " +
                QuizContract1.QuestionsTable1._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract1.QuestionsTable1.COLUMN_QUESTION_1 + " TEXT, " +
                QuizContract1.QuestionsTable1.COLUMN_OPTION1_1 + " TEXT, " +
                QuizContract1.QuestionsTable1.COLUMN_OPTION2_1 + " TEXT, " +
                QuizContract1.QuestionsTable1.COLUMN_OPTION3_1 + " TEXT, " +
                QuizContract1.QuestionsTable1.COLUMN_OPTION4_1 + " TEXT, " +
                QuizContract1.QuestionsTable1.COLUMN_ANSWER_NR_1 + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE_1);
        fillQuestionsTable1();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract1.QuestionsTable1.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable1() {
        Question1 q1 = new Question1("Boleh, sedikit","ได้นิดหน่อยครับ", "ยินดีตอนรับครับ","คุณพูดภาษาอังกฤษได้ไหมครับ", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion1(q1);
        Question1 q2 = new Question1("Awak boleh bertutur Bahasa Inggeris","คุณพูดภาษาอังกฤษได้ไหมครับ","สวัสดีตอนเช้าครับ", "วันนี้อากาศดีมากน่ะครับ", "ขอให้โชคดีน่ะครับ", 1);
        addQuestion1(q2);
        Question1 q3 = new Question1("Gembira dapat berjumpa awak", "แล้วเจอกันใหม่พรุ่งนี้น่ะครับ", "ยินดีที่ได้เจอคุณครับ", "มีอะไรให้ช่วยไหมครับ", "ไปก่อนน่ะครับ", 2);
        addQuestion1(q3);
        Question1 q4 = new Question1("นาง","sedikit", "Selamat tinggal","Puan","Encik", 3);
        addQuestion1(q4);
        Question1 q5 = new Question1("Tidak", "ขอให้มีความสุขมากๆ", "ไม่ได้ครับ", "แล้วพบกันใหม่นะครับ", "เดียวเจอกันใหม่", 2);
        addQuestion1(q5);
        Question1 q6 = new Question1("นาย","Selamat tinggal", "Boleh saya bantu awak","Jumpa awak nanti", "Encik", 4);
        addQuestion1(q6);
    }
    private void addQuestion1(Question1 question1) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract1.QuestionsTable1.COLUMN_QUESTION_1, question1.getQuestion_1());
        cv.put(QuizContract1.QuestionsTable1.COLUMN_OPTION1_1, question1.getOption1_1());
        cv.put(QuizContract1.QuestionsTable1.COLUMN_OPTION2_1, question1.getOption2_1());
        cv.put(QuizContract1.QuestionsTable1.COLUMN_OPTION3_1, question1.getOption3_1());
        cv.put(QuizContract1.QuestionsTable1.COLUMN_OPTION4_1, question1.getOption4_1());
        cv.put(QuizContract1.QuestionsTable1.COLUMN_ANSWER_NR_1, question1.getAnswerNr_1());
        db.insert(QuizContract1.QuestionsTable1.TABLE_NAME,null, cv);

    }
    public ArrayList<Question1> getAllQuestions1() {
        ArrayList<Question1> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract1.QuestionsTable1.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                Question1 question1 = new Question1();
                question1.setQuestion_1(c.getString(c.getColumnIndex(QuizContract1.QuestionsTable1.COLUMN_QUESTION_1)));
                question1.setOption1_1(c.getString(c.getColumnIndex(QuizContract1.QuestionsTable1.COLUMN_OPTION1_1)));
                question1.setOption2_1(c.getString(c.getColumnIndex(QuizContract1.QuestionsTable1.COLUMN_OPTION2_1)));
                question1.setOption3_1(c.getString(c.getColumnIndex(QuizContract1.QuestionsTable1.COLUMN_OPTION3_1)));
                question1.setOption4_1(c.getString(c.getColumnIndex(QuizContract1.QuestionsTable1.COLUMN_OPTION4_1)));
                question1.setAnswerNr_1(c.getInt(c.getColumnIndex(QuizContract1.QuestionsTable1.COLUMN_ANSWER_NR_1)));
                questionList.add(question1);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}

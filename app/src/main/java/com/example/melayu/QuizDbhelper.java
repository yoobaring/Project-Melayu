package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.melayu.Question;
import com.example.melayu.QuizContract;

import java.util.ArrayList;


import static com.example.melayu.QuizContract.QuestionsTable.COLUMN_OPTION4;

public class QuizDbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 7;

    private SQLiteDatabase db;

    public QuizDbhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
            QuizContract.QuestionsTable.TABLE_NAME + " ( " +
            QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + //เป็นคำสั่งที่ใช้สำหรับการสร้าง Auto Number หรือตัวเลขรันอัตโนมัติ
            QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
            QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
            QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
            QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
            QuizContract.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
            QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question( "Maafkan saya","มีอะไรให้ช่วยไหมครับ", "ยินดีตอนรับครับ","ขอโทษครับ (เมื่อเดินชนผู้อื่น)", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion(q1);
        Question q2 = new Question("Selamat tengah hari", "สวัสดีตอนบ่ายครับ", "สวัสดีตอนเช้าครับ", "วันนี้อากาศดีมากน่ะครับ", "ขอให้โชคดีน่ะครับ", 1);
        addQuestion(q2);
        Question q3 = new Question( "แล้วเจอกันใหม่พรุ่งนี้น่ะครับ","Jompa lagi esok","Boleh saya bantu awak","Jumpa awak nanti","Awak pula", 1);
        addQuestion(q3);
        Question q4 = new Question("Awak pula","มีอะไรให้ช่วยไหมครับ", "ยินดีตอนรับครับ","แล้วคุณล่ะครับ", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion(q4);
        Question q5 = new Question("มีอะไรให้ช่วยไหมครับ","Maafkan saya","Boleh saya bantu awak","Tidak", "Gembira dapat berjumpa awak", 2);
        addQuestion(q5);
        Question q6 = new Question("Jumpa awak nanti", "แล้วพบกันใหม่นะครับ", "สวัสดีตอนเช้าครับ", "วันนี้อากาศดีมากน่ะครับ", "ขอให้โชคดีน่ะครับ", 1);
        addQuestion(q6);
        Question q7 = new Question("ยินดีต้อนรับครับ","Selamat datang", "Gembira dapat berjumpa awak","Selamat tinggal","Boleh sedikit", 1);
        addQuestion(q7);
        Question  q8 = new Question("Selamat malam", "ได้นิดหน่อย", "เดียวเจอกันใหม่", "ยินดีที่ได้รู้จักกัน", "ราตรีสวัสดิ์ครับ", 4);
        addQuestion(q8);
        Question q9 = new Question("แล้วคุณล่ะครับ", "Selamat tinggal", "Boleh saya bantu awak","Jumpa awak nanti", "Awak pula", 4);
        addQuestion(q9);
        Question q10 = new Question("Selamat tinggal", "คุณพูดว่าอะไรน่ะครับ","ลาก่อนครับ","มีอะไรให้ช่วยไหมครับ","ไปก่อนน่ะครับ", 2);
        addQuestion(q10);

    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}

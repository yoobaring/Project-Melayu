package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuizDbhelperS extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyAwesomeQuizS.db";
    private static final int DATABASE_VERSION = 6;

    private SQLiteDatabase db;

    public QuizDbhelperS(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContractS.QuestionsTable.TABLE_NAME + " ( " +
                QuizContractS.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + //เป็นคำสั่งที่ใช้สำหรับการสร้าง Auto Number หรือตัวเลขรันอัตโนมัติ
                QuizContractS.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContractS.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContractS.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContractS.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContractS.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuizContractS.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContractS.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        QuestionS q1 = new QuestionS("Hai! Bird lama tidak berjumpa. Apa khabar?","ลูกสุดาผู้ชายหรือผู้หญิง?","มีลูกกี่คนแล้วจ๊ะ?","แล้วลูกสุดาอายุเท่าไหร่แล้ว?","เบิร์ดไม่ได้ผมกันนาน สบายดีมั๊ย?",4);
        addQuestion(q1);
        QuestionS q2 = new QuestionS("Anak Bird berapa umur?","(ลูกฉันอายุเก้าขวบครับ)","แล้วลูกเบิร์ดอายุเท่าไหร่แล้ว?","ลูกๆอามาลอายุเท่าไหร่แล้วจ๊ะ?","สบายดีไหม?",2);
        addQuestion(q2);
        QuestionS q3 = new QuestionS("Bagaimanakah Amala?","เป็นอย่างไรบ้าง?","สบายดีไหม","โชคดีน่ะ","อายุเท่าไรแล้ว",1);
        addQuestion(q3);
        QuestionS q4 = new QuestionS("มีลูกกี่คนแล้วจ๊ะ?","Anak Bird berapa umur?","Anak saya berumur 9 tahun.","Anak berapa umur?","Ada anak berapa orang?",4);
        addQuestion(q4);
        QuestionS q5 = new QuestionS("แล้วเบิร์ดล่ะ?","Berapa orangkah anak?","Anak Bird berapa umur?","Bagai manakah Bird?","Saya baik.",3);
        addQuestion(q5);


    }

    private void addQuestion(QuestionS question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContractS.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContractS.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContractS.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContractS.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContractS.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuizContractS.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContractS.QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<QuestionS> getAllQuestions() {
        ArrayList<QuestionS> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContractS.QuestionsTable.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                QuestionS question = new QuestionS();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContractS.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContractS.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContractS.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContractS.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContractS.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContractS.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}

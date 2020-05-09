package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuizDbhelperB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuizB.db";
    private static final int DATABASE_VERSION = 7;

    private SQLiteDatabase db;

    public QuizDbhelperB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContractA.QuestionsTable.TABLE_NAME + " ( " +
                QuizContractA.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + //เป็นคำสั่งที่ใช้สำหรับการสร้าง Auto Number หรือตัวเลขรันอัตโนมัติ
                QuizContractA.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContractA.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContractA.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContractA.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContractA.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuizContractA.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContractB.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        QuestionB q1 = new QuestionB("  สิงโต", "Singa","Harimau","Rusa","Gajah",1);
        addQuestion(q1);
        QuestionB q2 = new QuestionB("  กระจง  "," Kuda","Kencil","Kerbau","Lembu",2);
        addQuestion(q2);
        QuestionB q3 = new QuestionB("Kuda","เป็ด","แพะ "," ม้า  "," ห่าน",3);
        addQuestion(q3);
        QuestionB q4 = new QuestionB("Tikus","เป็ด","กระจง "," ม้า  "," หนู",4);
        addQuestion(q4);
        QuestionB q5 = new QuestionB("จระเข้","Buaya","Babi","Arnab","Gajah",1);
        addQuestion(q5);
        QuestionB q6 = new QuestionB("แมว "," Arnab","Kucing","Keldai","Kura",2);
        addQuestion(q6);
        QuestionB q7 = new QuestionB("Biri-biri","ม้า"," เต่า ","กระจง","แกะ ",4);
        addQuestion(q7);
        QuestionB  q8 = new QuestionB("Kura","ม้า"," เต่า ","กระจง","แกะ ",2);
        addQuestion(q8);
        QuestionB q9 = new QuestionB("หมา","Buaya","Ayam","Anjing","Kerbau",3);
        addQuestion(q9);
        QuestionB q10 = new QuestionB("Angsa","ห่าน"," ม้า ","กระจง","กระต่าย ",1);
        addQuestion(q10);


    }

    private void addQuestion(QuestionB question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContractB.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContractB.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContractB.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContractB.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContractB.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuizContractB.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContractB.QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<QuestionB> getAllQuestions() {
        ArrayList<QuestionB> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContractB.QuestionsTable.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                QuestionB question = new QuestionB();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContractB.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContractB.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContractB.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContractB.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContractB.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContractB.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}


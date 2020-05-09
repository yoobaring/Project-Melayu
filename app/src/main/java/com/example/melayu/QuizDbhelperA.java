package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuizDbhelperA extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuizA.db";
    private static final int DATABASE_VERSION = 7;

    private SQLiteDatabase db;

    public QuizDbhelperA(@Nullable Context context) {
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
        db.execSQL("DROP TABLE IF EXISTS " + QuizContractA.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        QuestionA q1 = new QuestionA( "  ผลไม้ ", " Buah","Strawberi","Nanas"," Pisang",1);
        addQuestion(q1);
        QuestionA q2 = new QuestionA("  เชอร์รี่"," Pisang","Ceri","Nanas","Tembikai",2);
        addQuestion(q2);
        QuestionA q3 = new QuestionA("Strawberi","กล้วย","ส้มโอ","สตรอเบอร์รี่","มะนาว",3);
        addQuestion(q3);
        QuestionA q4 = new QuestionA("Pisang","กล้วย","มะหนาว","ส้มโอ","แตงโม",1);
        addQuestion(q4);
        QuestionA q5 = new QuestionA("  มะนาว","Strawberi","Nanas","Lemon","Pisang",3);
        addQuestion(q5);
        QuestionA q6 = new QuestionA(" องุ่น ","Anggur","Nanas","Strawberi","Pisang",4);
        addQuestion(q6);
        QuestionA q7 = new QuestionA("Limau gedang","ส้มโอ","สตรอเบอร์รี่","มะนาว","กล้วย",1);
        addQuestion(q7);
        QuestionA  q8 = new QuestionA("Tembikai","ส้มโอ","แตงโม","มะหนาว","กล้วย",2);
        addQuestion(q8);
        QuestionA q9 = new QuestionA("Nanas","ส้มโอ","สตรอเบอร์รี่","แตงโม","สับปะรด ",4);
        addQuestion(q9);


    }

    private void addQuestion(QuestionA question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContractA.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContractA.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContractA.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContractA.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContractA.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuizContractA.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContractA.QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<QuestionA> getAllQuestions() {
        ArrayList<QuestionA> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContractA.QuestionsTable.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                QuestionA question = new QuestionA();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContractA.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContractA.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContractA.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContractA.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContractA.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContractA.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}

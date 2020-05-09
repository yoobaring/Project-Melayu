package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.melayu.QuizContract2;

import java.util.ArrayList;

public class QuizDbHelper2 extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "MyAwesomeQuiz2.db";
    private static final int DATABASE_VERSION = 7;

    private SQLiteDatabase db;

    public QuizDbHelper2(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE_2= "CREATE TABLE " +
                QuizContract2.QuestionsTable2.TABLE_NAME + " ( " +
                QuizContract2.QuestionsTable2._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract2.QuestionsTable2.COLUMN_QUESTION_2 + " TEXT, " +
                QuizContract2.QuestionsTable2.COLUMN_OPTION1_2 + " TEXT, " +
                QuizContract2.QuestionsTable2.COLUMN_OPTION2_2 + " TEXT, " +
                QuizContract2.QuestionsTable2.COLUMN_OPTION3_2 + " TEXT, " +
                QuizContract2.QuestionsTable2.COLUMN_OPTION4_2 + " TEXT, " +
                QuizContract2.QuestionsTable2.COLUMN_ANSWER_NR_2 + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE_2);
        fillQuestionsTable2();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract2.QuestionsTable2.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable2() {
        Question2 q1 = new Question2("มันหมายความว่าอย่างไรครับ"," Apa maknanya","Perkataan demi perkataan","Sekali lagi","Jumpa awak nanti",1);
        addQuestion2(q1);
        Question2 q2 = new Question2("Perkataan demi perkataan","ยินดีตอนรับครับ","คุณพูดภาษาอังกฤษได้ไหมครับ","คำต่อคำ", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion2(q2);
        Question2 q3 = new Question2("คุณพูดว่าอะไรนะครับ","Maafkan saya","Apa yang awak cakap","Tidak", "Gembira dapat berjumpa awak", 2);
        addQuestion2(q3);
        Question2 q4 = new Question2("ช้าๆ", "Selamat tinggal", "Boleh saya bantu awak","Sekali lagi", "Perlahan-lahan", 4);
        addQuestion2(q4);
        Question2 q5 = new Question2("Bagaimana awak kata", "คุณพูดว่าอะไรน่ะครับ","ผมควรพูดว่าอย่างไรครับ","มีอะไรให้ช่วยไหมครับ","ไปก่อนน่ะครับ", 2);
        addQuestion2(q5);
        Question2 q6 = new Question2("Cakap perlahan","มีอะไรให้ช่วยไหมครับ", "ยินดีตอนรับครับ","พูดช้าๆ หน่อยนะครับ", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion2(q6);
        Question2 q7 = new Question2("Sila ulang", "พูดซ้ำอีกครั้งได้ไหมครับ ", "สวัสดีตอนเช้าครับ", "วันนี้อากาศดีมากน่ะครับ", "ขอให้โชคดีน่ะครับ", 1);
        addQuestion2(q7);
        Question2 q8 = new Question2("คุณเข้าใจไหมครับ ","Boleh", "sedikit", "Awak faham"," Awak ada soalan", 3);
        addQuestion2(q8);
        Question2 q9 = new Question2("Awak ada soalan", "คุณมีคำถามไหมครับ", "สวัสดีตอนเช้าครับ", "วันนี้อากาศดีมากน่ะครับ", "ขอให้โชคดีน่ะครับ", 1);
        addQuestion2(q9);
        Question2 q10 = new Question2("ขออีกครั้ง ","Boleh"," sedikit","Jumpa awak nanti", "Sekali lagi", 4);
        addQuestion2(q10);


    }
    private void addQuestion2(Question2 question2) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract2.QuestionsTable2.COLUMN_QUESTION_2, question2.getQuestion_2());
        cv.put(QuizContract2.QuestionsTable2.COLUMN_OPTION1_2, question2.getOption1_2());
        cv.put(QuizContract2.QuestionsTable2.COLUMN_OPTION2_2, question2.getOption2_2());
        cv.put(QuizContract2.QuestionsTable2.COLUMN_OPTION3_2, question2.getOption3_2());
        cv.put(QuizContract2.QuestionsTable2.COLUMN_OPTION4_2, question2.getOption4_2());
        cv.put(QuizContract2.QuestionsTable2.COLUMN_ANSWER_NR_2, question2.getAnswerNr_2());
        db.insert(QuizContract2.QuestionsTable2.TABLE_NAME,null, cv);

    }
    public ArrayList<Question2> getAllQuestions2() {
        ArrayList<Question2> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract2.QuestionsTable2.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                Question2 question2 = new Question2();
                question2.setQuestion_2(c.getString(c.getColumnIndex(QuizContract2.QuestionsTable2.COLUMN_QUESTION_2)));
                question2.setOption1_2(c.getString(c.getColumnIndex(QuizContract2.QuestionsTable2.COLUMN_OPTION1_2)));
                question2.setOption2_2(c.getString(c.getColumnIndex(QuizContract2.QuestionsTable2.COLUMN_OPTION2_2)));
                question2.setOption3_2(c.getString(c.getColumnIndex(QuizContract2.QuestionsTable2.COLUMN_OPTION3_2)));
                question2.setOption4_2(c.getString(c.getColumnIndex(QuizContract2.QuestionsTable2.COLUMN_OPTION4_2)));
                question2.setAnswerNr_2(c.getInt(c.getColumnIndex(QuizContract2.QuestionsTable2.COLUMN_ANSWER_NR_2)));
                questionList.add(question2);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}

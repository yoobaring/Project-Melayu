package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuizDbHelper5 extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "MyAwesomeQuiz5.db";
    private static final int DATABASE_VERSION = 7;

    private SQLiteDatabase db;

    public QuizDbHelper5(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE_5= "CREATE TABLE " +
                QuizContract5.QuestionsTable5.TABLE_NAME + " ( " +
                QuizContract5.QuestionsTable5._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract5.QuestionsTable5.COLUMN_QUESTION_5 + " TEXT, " +
                QuizContract5.QuestionsTable5.COLUMN_OPTION1_5 + " TEXT, " +
                QuizContract5.QuestionsTable5.COLUMN_OPTION2_5 + " TEXT, " +
                QuizContract5.QuestionsTable5.COLUMN_OPTION3_5 + " TEXT, " +
                QuizContract5.QuestionsTable5.COLUMN_OPTION4_5 + " TEXT, " +
                QuizContract5.QuestionsTable5.COLUMN_ANSWER_NR_5 + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE_5);
        fillQuestionsTable5();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +QuizContract5.QuestionsTable5.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable5() {
        Question5 q1 = new Question5("Dengan apa", "ของใคร" ,  "คุณมีไหม" , "ใคร", "กับสิ่งไหน", 4);
        addQuestion5(q1);
        Question5 q2 = new Question5("ของใคร",  "Siapa punya", "Awak ada", "Dengan apa", "Siapa", 1 );
        addQuestion5(q2);
        Question5 q3 = new Question5("Kepada siapa", "ทำไม", " ที่ไหน" , " อันไหน", " ถึงใคร" , 4);
        addQuestion5(q3);
        Question5 q4 = new Question5("Mengapa"," อันไหน", " ถึงใคร", "ทำไม", "เท่าไร", 3);
        addQuestion5(q4);
        Question5 q5 = new Question5("เท่าไร ", "Berapa lama", "Berapa banyak", "Kepada siapa", " Yang mana", 2);
        addQuestion5(q5);
        Question5 q6 = new Question5("คุณมีไหม", "Siapa punya", " Awak ada", "Dengan apa", "Di", 2);
        addQuestion5(q6);
        Question5 q7 = new Question5("อย่างไร", "Apa", "Mengapa", "Di", "Bagaimana", 4);
        addQuestion5(q7);
        Question5 q8 = new Question5("Berapa lama", "กับสิ่งไหน ", "คุณมีไหม ", "นานเท่าไหร่", "อะไร", 3);
        addQuestion5(q8);
        Question5 q9 = new Question5("Awak ada", "ที่ไหน", "ทำไม", "คุณมีไหม ", "ใคร", 3);
        addQuestion5(q9);
        Question5 q10 = new Question5("Yang mana", "เท่าไร", "อย่างไร", "นานเท่าไหร่", "ถึงใคร", 1);
        addQuestion5(q10);


    }
    private void addQuestion5(Question5 question5) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract5.QuestionsTable5.COLUMN_QUESTION_5, question5.getQuestion_5());
        cv.put(QuizContract5.QuestionsTable5.COLUMN_OPTION1_5, question5.getOption1_5());
        cv.put(QuizContract5.QuestionsTable5.COLUMN_OPTION2_5, question5.getOption2_5());
        cv.put(QuizContract5.QuestionsTable5.COLUMN_OPTION3_5, question5.getOption3_5());
        cv.put(QuizContract5.QuestionsTable5.COLUMN_OPTION4_5, question5.getOption4_5());
        cv.put(QuizContract5.QuestionsTable5.COLUMN_ANSWER_NR_5, question5.getAnswerNr_5());
        db.insert(QuizContract5.QuestionsTable5.TABLE_NAME,null, cv);

    }
    public ArrayList<Question5> getAllQuestions5() {
        ArrayList<Question5> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " +QuizContract5.QuestionsTable5.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                Question5 question5 = new Question5();
                question5.setQuestion_5(c.getString(c.getColumnIndex(QuizContract5.QuestionsTable5.COLUMN_QUESTION_5)));
                question5.setOption1_5(c.getString(c.getColumnIndex(QuizContract5.QuestionsTable5.COLUMN_OPTION1_5)));
                question5.setOption2_5(c.getString(c.getColumnIndex(QuizContract5.QuestionsTable5.COLUMN_OPTION2_5)));
                question5.setOption3_5(c.getString(c.getColumnIndex(QuizContract5.QuestionsTable5.COLUMN_OPTION3_5)));
                question5.setOption4_5(c.getString(c.getColumnIndex(QuizContract5.QuestionsTable5.COLUMN_OPTION4_5)));
                question5.setAnswerNr_5(c.getInt(c.getColumnIndex(QuizContract5.QuestionsTable5.COLUMN_ANSWER_NR_5)));
                questionList.add(question5);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}


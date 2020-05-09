package com.example.melayu;

import android.provider.BaseColumns;

public final class QuizContract2 {

    private  QuizContract2() {}

    public static class  QuestionsTable2 implements BaseColumns{
        public static final String TABLE_NAME = "quiz_questions2";
        public static final String COLUMN_QUESTION_2 = "question_2";
        public static final String COLUMN_OPTION1_2 = "option1_2";
        public static final String COLUMN_OPTION2_2 = "option2_2";
        public static final String COLUMN_OPTION3_2 = "option3_2";
        public static final String COLUMN_OPTION4_2 = "option4_2";
        public static final String COLUMN_ANSWER_NR_2 = "answer_nr_2";
    }
}

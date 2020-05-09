package com.example.melayu;

import android.provider.BaseColumns;

public class QuizContract3 {
    private  QuizContract3() {}

    public static class  QuestionsTable3 implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions3";
        public static final String COLUMN_QUESTION_3 = "question_3";
        public static final String COLUMN_OPTION1_3 = "option1_3";
        public static final String COLUMN_OPTION2_3 = "option2_3";
        public static final String COLUMN_OPTION3_3 = "option3_3";
        public static final String COLUMN_OPTION4_3 = "option4_3";
        public static final String COLUMN_ANSWER_NR_3 = "answer_nr_3";
    }
}


package com.example.melayu;

import android.provider.BaseColumns;

public final class QuizContract1 {

    private  QuizContract1() {}

    public static class  QuestionsTable1 implements BaseColumns{
        public static final String TABLE_NAME = "quiz_questions1";
        public static final String COLUMN_QUESTION_1 = "question_1";
        public static final String COLUMN_OPTION1_1 = "option1_1";
        public static final String COLUMN_OPTION2_1 = "option2_1";
        public static final String COLUMN_OPTION3_1 = "option3_1";
        public static final String COLUMN_OPTION4_1 = "option4_1";
        public static final String COLUMN_ANSWER_NR_1 = "answer_nr_1";
    }
}

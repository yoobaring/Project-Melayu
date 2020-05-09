package com.example.melayu;

import android.os.Parcel;
import android.os.Parcelable;

public class Question1 implements Parcelable {
    private String question_1;
    private String option1_1;
    private String option2_1;
    private String option3_1;
    private String option4_1;
    private int answerNr_1;

    public Question1() {}

    public Question1(String question_1, String option1_1, String option2_1, String option3_1, String option4_1, int answerNr_1) {
        this.question_1 = question_1;
        this.option1_1 = option1_1;
        this.option2_1 = option2_1;
        this.option3_1 = option3_1;
        this.option4_1 = option4_1;
        this.answerNr_1 = answerNr_1;
    }

    public Question1(Parcel in) {
        question_1 = in.readString();
        option1_1 = in.readString();
        option2_1 = in.readString();
        option3_1 = in.readString();
        option4_1 = in.readString();
        answerNr_1 = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question_1);
        dest.writeString(option1_1);
        dest.writeString(option2_1);
        dest.writeString(option3_1);
        dest.writeString(option4_1);
        dest.writeInt(answerNr_1);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question1> CREATOR = new Creator<Question1>() {
        @Override
        public Question1 createFromParcel(Parcel in) {
            return new Question1(in);
        }

        @Override
        public Question1[] newArray(int size) {

            return new Question1[size];
        }
    };

    public String getQuestion_1() {
        return question_1;
    }

    public void setQuestion_1(String question_1) {
        this.question_1 = question_1;
    }

    public String getOption1_1() {
        return option1_1;
    }

    public void setOption1_1(String option1_1) {
        this.option1_1 = option1_1;
    }

    public String getOption2_1() {
        return option2_1;
    }

    public void setOption2_1(String option2_1) {
        this.option2_1 = option2_1;
    }

    public String getOption3_1() {
        return option3_1;
    }

    public void setOption3_1(String option3_1) {
        this.option3_1 = option3_1;
    }

    public String getOption4_1() {
        return option4_1;
    }

    public void setOption4_1(String option4_1) {
        this.option4_1 = option4_1;
    }

    public int getAnswerNr_1() {
        return answerNr_1;
    }

    public void setAnswerNr_1(int answerNr_1) {
        this.answerNr_1 = answerNr_1;
    }


}

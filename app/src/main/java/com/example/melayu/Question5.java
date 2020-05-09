package com.example.melayu;

import android.os.Parcel;
import android.os.Parcelable;

public class Question5 implements Parcelable {
    private String question_5;
    private String option1_5;
    private String option2_5;
    private String option3_5;
    private String option4_5;
    private int answerNr_5;

    public Question5() {}

    public Question5(String question_5, String option1_5, String option2_5, String option3_5, String option4_5, int answerNr_5) {
        this.question_5 = question_5;
        this.option1_5 = option1_5;
        this.option2_5 = option2_5;
        this.option3_5 = option3_5;
        this.option4_5 = option4_5;
        this.answerNr_5 = answerNr_5;
    }

    public Question5(Parcel in) {
        question_5 = in.readString();
        option1_5 = in.readString();
        option2_5 = in.readString();
        option3_5 = in.readString();
        option4_5 = in.readString();
        answerNr_5 = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question_5);
        dest.writeString(option1_5);
        dest.writeString(option2_5);
        dest.writeString(option3_5);
        dest.writeString(option4_5);
        dest.writeInt(answerNr_5);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question5> CREATOR = new Creator<Question5>() {
        @Override
        public Question5 createFromParcel(Parcel in) {
            return new Question5(in);
        }

        @Override
        public Question5[] newArray(int size) {

            return new Question5[size];
        }
    };

    public String getQuestion_5() {
        return question_5;
    }

    public void setQuestion_5(String question_5) {
        this.question_5 = question_5;
    }

    public String getOption1_5() {
        return option1_5;
    }

    public void setOption1_5(String option1_5) {
        this.option1_5 = option1_5;
    }

    public String getOption2_5() {
        return option2_5;
    }

    public void setOption2_5(String option2_5) {
        this.option2_5 = option2_5;
    }

    public String getOption3_5() {
        return option3_5;
    }

    public void setOption3_5(String option3_5) {
        this.option3_5 = option3_5;
    }

    public String getOption4_5() {
        return option4_5;
    }

    public void setOption4_5(String option4_5) {
        this.option4_5 = option4_5;
    }

    public int getAnswerNr_5() {
        return answerNr_5;
    }

    public void setAnswerNr_5(int answerNr_5) {
        this.answerNr_5 = answerNr_5;
    }


}


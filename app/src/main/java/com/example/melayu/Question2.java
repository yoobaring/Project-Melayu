package com.example.melayu;

import android.os.Parcel;
import android.os.Parcelable;

public class Question2 implements Parcelable {
    private String question_2;
    private String option1_2;
    private String option2_2;
    private String option3_2;
    private String option4_2;
    private int answerNr_2;

    public Question2() {}

    public Question2(String question_2, String option1_2, String option2_2, String option3_2, String option4_2, int answerNr_2) {
        this.question_2 = question_2;
        this.option1_2 = option1_2;
        this.option2_2 = option2_2;
        this.option3_2 = option3_2;
        this.option4_2 = option4_2;
        this.answerNr_2 = answerNr_2;
    }

    public Question2(Parcel in) {
        question_2 = in.readString();
        option1_2 = in.readString();
        option2_2 = in.readString();
        option3_2 = in.readString();
        option4_2 = in.readString();
        answerNr_2 = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question_2);
        dest.writeString(option1_2);
        dest.writeString(option2_2);
        dest.writeString(option3_2);
        dest.writeString(option4_2);
        dest.writeInt(answerNr_2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question2> CREATOR = new Creator<Question2>() {
        @Override
        public Question2 createFromParcel(Parcel in) {
            return new Question2(in);
        }

        @Override
        public Question2[] newArray(int size) {

            return new Question2[size];
        }
    };

    public String getQuestion_2() {
        return question_2;
    }

    public void setQuestion_2(String question_2) {
        this.question_2 = question_2;
    }

    public String getOption1_2() {
        return option1_2;
    }

    public void setOption1_2(String option1_2) {
        this.option1_2 = option1_2;
    }

    public String getOption2_2() {
        return option2_2;
    }

    public void setOption2_2(String option2_2) {
        this.option2_2 = option2_2;
    }

    public String getOption3_2() {
        return option3_2;
    }

    public void setOption3_2(String option3_2) {
        this.option3_2 = option3_2;
    }

    public String getOption4_2() {
        return option4_2;
    }

    public void setOption4_2(String option4_2) {
        this.option4_2 = option4_2;
    }

    public int getAnswerNr_2() {
        return answerNr_2;
    }

    public void setAnswerNr_2(int answerNr_2) {
        this.answerNr_2 = answerNr_2;
    }


}

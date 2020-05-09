package com.example.melayu;

import android.os.Parcel;
import android.os.Parcelable;

public class Question3 implements Parcelable {
    private String question_3;
    private String option1_3;
    private String option2_3;
    private String option3_3;
    private String option4_3;
    private int answerNr_3;

    public Question3() {}

    public Question3(String question_3, String option1_3, String option2_3, String option3_3, String option4_3, int answerNr_3) {
        this.question_3 = question_3;
        this.option1_3 = option1_3;
        this.option2_3 = option2_3;
        this.option3_3 = option3_3;
        this.option4_3 = option4_3;
        this.answerNr_3 = answerNr_3;
    }

    public Question3(Parcel in) {
        question_3 = in.readString();
        option1_3 = in.readString();
        option2_3 = in.readString();
        option3_3 = in.readString();
        option4_3 = in.readString();
        answerNr_3 = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question_3);
        dest.writeString(option1_3);
        dest.writeString(option2_3);
        dest.writeString(option3_3);
        dest.writeString(option4_3);
        dest.writeInt(answerNr_3);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question3> CREATOR = new Creator<Question3>() {
        @Override
        public Question3 createFromParcel(Parcel in) {
            return new Question3(in);
        }

        @Override
        public Question3[] newArray(int size) {

            return new Question3[size];
        }
    };

    public String getQuestion_3() {
        return question_3;
    }

    public void setQuestion_3(String question_3) {
        this.question_3 = question_3;
    }

    public String getOption1_3() {
        return option1_3;
    }

    public void setOption1_3(String option1_3) {
        this.option1_3 = option1_3;
    }

    public String getOption2_3() {
        return option2_3;
    }

    public void setOption2_3(String option2_3) {
        this.option2_3 = option2_3;
    }

    public String getOption3_3() {
        return option3_3;
    }

    public void setOption3_3(String option3_3) {
        this.option3_3 = option3_3;
    }

    public String getOption4_3() {
        return option4_3;
    }

    public void setOption4_3(String option4_3) {
        this.option4_3 = option4_3;
    }

    public int getAnswerNr_3() {
        return answerNr_3;
    }

    public void setAnswerNr_3(int answerNr_3) {
        this.answerNr_3 = answerNr_3;
    }


}

package com.example.melayu;

import android.os.Parcel;
import android.os.Parcelable;

public class Question4 implements Parcelable {
    private String question_4;
    private String option1_4;
    private String option2_4;
    private String option3_4;
    private String option4_4;
    private int answerNr_4;

    public Question4() {}

    public Question4(String question_4, String option1_4, String option2_4, String option3_4, String option4_4, int answerNr_4) {
        this.question_4 = question_4;
        this.option1_4 = option1_4;
        this.option2_4 = option2_4;
        this.option3_4 = option3_4;
        this.option4_4 = option4_4;
        this.answerNr_4 = answerNr_4;
    }

    public Question4(Parcel in) {
        question_4 = in.readString();
        option1_4 = in.readString();
        option2_4 = in.readString();
        option3_4 = in.readString();
        option4_4 = in.readString();
        answerNr_4 = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question_4);
        dest.writeString(option1_4);
        dest.writeString(option2_4);
        dest.writeString(option3_4);
        dest.writeString(option4_4);
        dest.writeInt(answerNr_4);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question4> CREATOR = new Creator<Question4>() {
        @Override
        public Question4 createFromParcel(Parcel in) {
            return new Question4(in);
        }

        @Override
        public Question4[] newArray(int size) {

            return new Question4[size];
        }
    };

    public String getQuestion_4() {
        return question_4;
    }

    public void setQuestion_4(String question_4) {
        this.question_4 = question_4;
    }

    public String getOption1_4() {
        return option1_4;
    }

    public void setOption1_4(String option1_4) {
        this.option1_4 = option1_4;
    }

    public String getOption2_4() {
        return option2_4;
    }

    public void setOption2_4(String option2_4) {
        this.option2_4 = option2_4;
    }

    public String getOption3_4() {
        return option3_4;
    }

    public void setOption3_4(String option3_4) {
        this.option3_4 = option3_4;
    }

    public String getOption4_4() {
        return option4_4;
    }

    public void setOption4_4(String option4_4) {
        this.option4_4 = option4_4;
    }

    public int getAnswerNr_4() {
        return answerNr_4;
    }

    public void setAnswerNr_4(int answerNr_4) {
        this.answerNr_4 = answerNr_4;
    }


}


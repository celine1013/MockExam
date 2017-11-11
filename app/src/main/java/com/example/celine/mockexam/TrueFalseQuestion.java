package com.example.celine.mockexam;

import android.os.Parcel;

/**
 * Created by Celine on 11/11/2017.
 */

public class TrueFalseQuestion extends Question {

    private boolean answer;

    public TrueFalseQuestion() {
    }

    public TrueFalseQuestion(String question, int questionType, int questionCategory, boolean answer) {
        super(question, questionType, questionCategory);
        this.answer = answer;
    }

    public TrueFalseQuestion(Parcel in) {
        super(in);
        answer = in.readInt()!=0;
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(answer ? 1 : 0);
    }

    public static final Creator<TrueFalseQuestion> CREATOR = new Creator<TrueFalseQuestion>() {
        @Override
        public TrueFalseQuestion createFromParcel(Parcel in) {
            return new TrueFalseQuestion(in);
        }

        @Override
        public TrueFalseQuestion[] newArray(int size) {
            return new TrueFalseQuestion[size];
        }
    };

    public boolean isAnswer() {
        return answer;
    }
}

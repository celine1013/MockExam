package com.example.celine.mockexam;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Celine on 11/11/2017.
 */

public class TextAnsQuestion extends Question {
    private String answer;

    public TextAnsQuestion(String question, int questionType, int questionCategory, String answer) {
        super(question, questionType, questionCategory);
        this.answer = answer;
    }

    public TextAnsQuestion(Parcel in) {
        super(in);
        this.answer = in.readString();
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(answer);
    }

    public static final Creator<TextAnsQuestion> CREATOR = new Creator<TextAnsQuestion>() {
        @Override
        public TextAnsQuestion createFromParcel(Parcel in) {
            return new TextAnsQuestion(in);
        }

        @Override
        public TextAnsQuestion[] newArray(int size) {
            return new TextAnsQuestion[size];
        }
    };

    public String getAnswer() {
        return answer;
    }
}



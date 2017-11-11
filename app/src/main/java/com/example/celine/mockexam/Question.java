package com.example.celine.mockexam;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Celine on 11/11/2017.
 */

public class Question implements Parcelable {
    private String question;
    private int questionType; //maybe not neccessary
    private int questionCategory;

    public static final int TEXT_QUESTION = 0;
    public static final int TRUEFALSE_QUESTION = 1;

    public Question() {
    }

    public Question(String question, int questionType, int questionCategory) {
        this.question = question;
        this.questionType = questionType;
        this.questionCategory = questionCategory;
    }

    protected Question(Parcel in) {
        question = in.readString();
        questionType = in.readInt();
        questionCategory = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeInt(questionType);
        parcel.writeInt(questionCategory);
    }

    public String getQuestion() {
        return question;
    }

    public int getQuestionType() {
        return questionType;
    }

    public int getQuestionCategory() {
        return questionCategory;
    }
}
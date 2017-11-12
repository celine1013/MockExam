package com.example.celine.mockexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    public static final String TAG_CATE ="tag_cate";
    public static final String TAG_SCORE = "tag_score";

    private LinearLayout ans_mcqs;
    private LinearLayout ans_mcqm;
    private RelativeLayout ans_ft;

    private TextView q_cate;
    private TextView q_score;
    private TextView q_question;

    private Button btn_next;

    private List<Question> questions;
    private int score = 0;
    private int currentQuestionNum = 0;
    private Question question;
    private int cate = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        cate = getIntent().getIntExtra(MainActivity.TAG_CATEGORY, -1);

        //bind view
        btn_next = findViewById(R.id.btn_next);

        //setView based on question type
        question = questions.get(currentQuestionNum);
        setQuestion(question);
        currentQuestionNum++;
        //determine button listener
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verify answer
                //calculate score
                verifyAnswer(question);
                //if last question, next becomes submit
                if(currentQuestionNum < questions.size()){
                    question = questions.get(currentQuestionNum);
                    setQuestion(question);
                    currentQuestionNum++;
                }else{
                    //show score and return it to the main activity
                    String msg = "You got " + score + " in this quiz!";
                    Toast.makeText(QuizActivity.this, msg, Toast.LENGTH_SHORT).show();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(MainActivity.TAG_CATEGORY, cate);
                    resultIntent.putExtra(MainActivity.TAG_SCORE, score);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }

            }
        });



    }

    private RadioGroup tf_answerSet;
    private RadioButton rb_selected;
    private void setQuestion(Question q){
        //set correspondant answer set view
        //disappear others
        //solution 1 for checking question type
        if(q.getQuestionType() == Question.TEXT_QUESTION){
            //set view
            ans_ft.setVisibility(View.VISIBLE);
            ans_mcqm.setVisibility(View.GONE);
            ans_mcqs.setVisibility(View.GONE);

        }else if(q.getQuestionType() == Question.TRUEFALSE_QUESTION){
            //set view
            ans_ft.setVisibility(View.GONE);
            ans_mcqm.setVisibility(View.GONE);
            ans_mcqs.setVisibility(View.VISIBLE);

            //set answer set
            tf_answerSet = findViewById(R.id.rg_answerset);
            tf_answerSet.clearCheck();
            tf_answerSet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int id) {
                    if(id == R.id.rb_true){
                        rb_selected = findViewById(R.id.rb_true);

                    }else if(id == R.id.rb_false){
                        rb_selected = findViewById(R.id.rb_true);
                    }
                }
            });
        }else{
            return;
        }
    }

    private void verifyAnswer(Question q){
        boolean correct = false;
        //solution 2 for checking question type
        if(q instanceof TrueFalseQuestion){
            boolean answer = ((TrueFalseQuestion) q).isAnswer();


        }else if(q instanceof TextAnsQuestion){
            String trueAnswer = ((TextAnsQuestion) q).getAnswer();

        }else{
            return;
        }
        
        if(correct)score += 10;
    }
}

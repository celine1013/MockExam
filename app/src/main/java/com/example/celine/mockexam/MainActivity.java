package com.example.celine.mockexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_cates;
    public static final String TAG_CATEGORY = "tag_catgory";
    public static final String TAG_SCORE = "tag_score";
    public static final int REQUEST_QUIZ = 0;

    private int[] scores = {0, 0, 0, 0};
    public List<Question> questionList;

    //question lists

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_cates = findViewById(R.id.rv_cates);
        rv_cates.setLayoutManager(new LinearLayoutManager(this));
        rv_cates.setAdapter(new CustomAdapter(this, scores));

        //create question lists

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_QUIZ && resultCode == RESULT_OK){
            int c = data.getIntExtra(QuizActivity.TAG_CATE, -1);
            int s = data.getIntExtra(QuizActivity.TAG_SCORE, 0);
            if(c==-1)return;

            //update the highest score
            if(s > scores[c])scores[c] = s;
        }
    }


}


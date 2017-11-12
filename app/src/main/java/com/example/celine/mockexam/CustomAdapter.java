package com.example.celine.mockexam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Celine on 11/11/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private String[] cates;
    private int[] scores;
    private Context mContext;

    public CustomAdapter(Context mContext, int[] scores) {
        this.scores = scores;
        this.mContext = mContext;
        this.cates = mContext.getResources().getStringArray(R.array.categories);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View itemView = layoutInflater.inflate(R.layout.list_item,parent,false);
        CustomViewHolder viewHolder= new CustomViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        final String cate = cates[position];
        final String score = String.valueOf(scores[position]);

        holder.tv_cate.setText(cate);
        holder.tv_score.setText(score);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,QuizActivity.class);
                intent.putExtra(MainActivity.TAG_CATEGORY, position);
                ((Activity)mContext).startActivityForResult(intent,MainActivity.REQUEST_QUIZ);
            }
        });
        Log.d("CUSTOM ADAPTER", "ONBINDVIEWHOLDER");
    }

    @Override
    public int getItemCount() {
        return cates.length;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_cate;
        public TextView tv_score;
        public View view;
        public CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tv_cate = itemView.findViewById(R.id.cat);
            tv_score = itemView.findViewById(R.id.score);
            Log.d("CUSTOM ADAPTER", "VIEW HOLDER SETTING");
        }
    }
}

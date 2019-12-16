package com.example.android_e_learning.adapter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_e_learning.Course;
import com.example.android_e_learning.CourseDetail;
import com.example.android_e_learning.R;
import com.example.android_e_learning.adapter.VideoAdapter;

import java.util.ArrayList;

public class AdapterHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Course> dataSet;
    private int total_types;
    private Activity activity;
    private Fragment fragment;
    MediaPlayer mPlayer;
    private boolean fabStateVolume = false;

    public AdapterHolder(ArrayList<Course> data, Activity activity, Fragment fragment) {
        this.dataSet = data;
        total_types = dataSet.size();
        this.activity = activity;
        this.fragment = fragment;
    }

    public static class FirstTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView courseName;
        TextView description;
        Activity activity;
        Fragment fragment;
        CardView cardView;
        private ListView listView;
        private int firstVisible;//当前第一个可见的item
        private int visibleCount;//当前可见的item个数

        public FirstTypeViewHolder(@NonNull View itemView, Activity activity, Fragment fragment) {
            super(itemView);
            this.courseName = (TextView) itemView.findViewById(R.id.coursename);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.cardView = (CardView) itemView.findViewById(R.id.first_view);
            cardView.setOnClickListener(this);
            this.activity = activity;
            this.fragment = fragment;

            listView = (ListView) itemView.findViewById(R.id.listview);
            ArrayList<String> datas = new ArrayList<String>();
            String videoUrl = "http://tang5618.com:8080/HTML/WEB/0.mp4";
            datas.add(videoUrl);
            VideoAdapter videoAdapter = new VideoAdapter(activity, datas, R.layout.item_video);
            listView.setAdapter(videoAdapter);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, CourseDetail.class);
            fragment.startActivity(intent);
            activity.overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
        }


    }


    public static class SecondTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView courseName;
        TextView description;
        CardView cardView;
        Activity activity;
        Fragment fragment;

        public SecondTypeViewHolder(View itemView, Activity activity, Fragment fragment) {
            super(itemView);
            this.courseName = (TextView) itemView.findViewById(R.id.coursename);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.cardView = (CardView) itemView.findViewById(R.id.second_view);
            cardView.setOnClickListener(this);
            this.activity = activity;
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, CourseDetail.class);
            fragment.startActivity(intent);
            activity.overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Course.FIRST_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_type, parent, false);
                return new FirstTypeViewHolder(view, activity, fragment);
            case Course.SECOND_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_type, parent, false);
                return new SecondTypeViewHolder(view, activity, fragment);

        }
        return null;

    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).getType()) {
            case 0:
                return Course.FIRST_TYPE;
            case 1:
                return Course.SECOND_TYPE;
            default:
                return -1;
        }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        Course object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.getType()) {
                case Course.FIRST_TYPE:
                    ((FirstTypeViewHolder) holder).courseName.setText(object.getName());
                    ((FirstTypeViewHolder) holder).description.setText(object.getDescription());
                    break;
                case Course.SECOND_TYPE:
                    ((SecondTypeViewHolder) holder).courseName.setText(object.getName());
                    ((SecondTypeViewHolder) holder).description.setText(object.getDescription());
                    break;

            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

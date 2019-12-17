package com.example.android_e_learning.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_e_learning.AsynImageLoader;
import com.example.android_e_learning.Course;
import com.example.android_e_learning.CourseDetail;
import com.example.android_e_learning.GetByURL;
import com.example.android_e_learning.Material;
import com.example.android_e_learning.R;
import com.example.android_e_learning.Teacher;
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
        ListView listView;
        ImageView imageView;
        TextView teacherNameView;
        TextView numOfShared;
        ArrayList<Course> data;


        @SuppressLint("ShowToast")
        public FirstTypeViewHolder(@NonNull View itemView, Activity activity, Fragment fragment, ArrayList<Course> data) {
            super(itemView);
            this.courseName = (TextView) itemView.findViewById(R.id.coursename);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.cardView = (CardView) itemView.findViewById(R.id.first_view);
            cardView.setOnClickListener(this);
            this.activity = activity;
            this.fragment = fragment;
            this.data = data;

            listView = (ListView) itemView.findViewById(R.id.listview);

            imageView = (ImageView) itemView.findViewById(R.id.img_video_icon);
            teacherNameView = (TextView) itemView.findViewById(R.id.tv_video_userName);
            numOfShared = (TextView) itemView.findViewById(R.id.tv_video_comment);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, CourseDetail.class);
            int position = this.getAdapterPosition();
            intent.putExtra("courseData", data.get(position));
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
        ArrayList<Course> data;

        public SecondTypeViewHolder(View itemView, Activity activity, Fragment fragment, ArrayList<Course> data) {
            super(itemView);
            this.courseName = (TextView) itemView.findViewById(R.id.coursename);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.cardView = (CardView) itemView.findViewById(R.id.second_view);
            cardView.setOnClickListener(this);
            this.activity = activity;
            this.fragment = fragment;
            this.data = data;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, CourseDetail.class);
            int position = this.getAdapterPosition();
            intent.putExtra("courseData", data.get(position));
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
                return new FirstTypeViewHolder(view, activity, fragment, dataSet);
            case Course.SECOND_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_type, parent, false);
                return new SecondTypeViewHolder(view, activity, fragment, dataSet);

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

    @SuppressLint("ShowToast")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        Course object = dataSet.get(listPosition);

        if (object != null) {
            switch (object.getType()) {
                case Course.FIRST_TYPE:
                    ArrayList<Teacher> arrayList = object.getArrayList();
                    String teacherId = arrayList.get(0).getUserId();
                    String teacherName = arrayList.get(0).getName();
                    int enrollment = object.getShared();
                    ArrayList<Material> mArrayList = object.getmArrayList();

                    ((FirstTypeViewHolder) holder).courseName.setText(object.getName());
                    ((FirstTypeViewHolder) holder).description.setText(object.getDescription());
                    String imageUrl = "http://tang5618.com:8080/elearn/teachers/" + teacherId + "/photo";

                    Glide.with(activity).load(imageUrl).into(((FirstTypeViewHolder) holder).imageView);
                    ((FirstTypeViewHolder) holder).teacherNameView.setText(teacherName);
                    ((FirstTypeViewHolder) holder).numOfShared.setText(String.valueOf(enrollment));

                    ArrayList<String> datas = new ArrayList<String>();

                    datas.add(mArrayList.get(0).getMaterialUrl());

                    VideoAdapter videoAdapter = new VideoAdapter(activity, datas, R.layout.item_video);
                    ((FirstTypeViewHolder) holder).listView.setAdapter(videoAdapter);




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

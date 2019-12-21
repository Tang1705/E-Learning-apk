package com.example.android_e_learning.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_e_learning.Course;
import com.example.android_e_learning.CourseDetailActivity;
import com.example.android_e_learning.Material;
import com.example.android_e_learning.R;
import com.example.android_e_learning.Teacher;
import com.example.android_e_learning.databinding.FirstTypeBinding;
import com.example.android_e_learning.databinding.SecondTypeBinding;
import com.example.android_e_learning.ui.home.HomeViewModel;

import java.util.ArrayList;

public class AdapterHolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Course> dataSet;
    private Activity activity;
    private Fragment fragment;

    public AdapterHolder(ArrayList<Course> data, Activity activity, Fragment fragment) {
        this.dataSet = data;
        this.activity = activity;
        this.fragment = fragment;
    }

    public static class FirstTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private FirstTypeBinding mBinding;
        Activity activity;
        Fragment fragment;
        ArrayList<Course> data;


        @SuppressLint("ShowToast")
        FirstTypeViewHolder(FirstTypeBinding binding, Activity activity, Fragment fragment, ArrayList<Course> data) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.firstView.setOnClickListener(this);
            this.activity = activity;
            this.fragment = fragment;
            this.data = data;

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, CourseDetailActivity.class);
            int position = this.getAdapterPosition();
            intent.putExtra("courseData", data.get(position));
            fragment.startActivity(intent);
            activity.overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
        }


    }


    public static class SecondTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SecondTypeBinding mBinding;
        Activity activity;
        Fragment fragment;
        ArrayList<Course> data;

        SecondTypeViewHolder(SecondTypeBinding binding, Activity activity, Fragment fragment, ArrayList<Course> data) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.secondView.setOnClickListener(this);
            this.activity = activity;
            this.fragment = fragment;
            this.data = data;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, CourseDetailActivity.class);
            int position = this.getAdapterPosition();
            intent.putExtra("courseData", data.get(position));
            fragment.startActivity(intent);
            activity.overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        switch (viewType) {
            case Course.FIRST_TYPE:
                FirstTypeBinding binding1 = DataBindingUtil.inflate(inflater, R.layout.first_type, parent, false);
                return new FirstTypeViewHolder(binding1, activity, fragment, dataSet);
            case Course.SECOND_TYPE:
                SecondTypeBinding binding2 = DataBindingUtil.inflate(inflater, R.layout.second_type, parent, false);
                return new SecondTypeViewHolder(binding2, activity, fragment, dataSet);
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
                    ((FirstTypeViewHolder) holder).mBinding.setHomeviewmodel(new HomeViewModel(object));
                    ArrayList<Teacher> arrayList = object.getArrayList();
                    String teacherId = arrayList.get(0).getUserId();
                    ArrayList<Material> mArrayList = object.getmArrayList();
                    String imageUrl = "http://tang5618.com:8080/elearn/teachers/" + teacherId + "/photo";

                    Glide.with(activity).load(imageUrl).into(((FirstTypeViewHolder) holder).mBinding.imgVideoIcon);
                    ArrayList<String> datas = new ArrayList<String>();

                    datas.add(mArrayList.get(0).getMaterialUrl());
                    VideoAdapter videoAdapter = new VideoAdapter(activity, datas, R.layout.item_video);
                    ((FirstTypeViewHolder) holder).mBinding.listview.setAdapter(videoAdapter);

                    break;
                case Course.SECOND_TYPE:
                    ((SecondTypeViewHolder) holder).mBinding.setHomeviewmodel(new HomeViewModel(object));
                    break;

            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

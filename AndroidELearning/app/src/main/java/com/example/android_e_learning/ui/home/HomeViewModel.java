package com.example.android_e_learning.ui.home;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android_e_learning.Course;
import com.example.android_e_learning.Teacher;

public class HomeViewModel extends BaseObservable {
    private Course course;
    private Teacher teacher;

    public HomeViewModel(Course course) {
        this.course = course;
        this.teacher = course.getArrayList().get(0);
    }

    @Bindable
    public Course getCourse() {
        return course;
    }

    @Bindable
    public void setCourse(Course course) {
        this.course = course;
        notifyChange();
    }

    @Bindable
    public Teacher getTeacher() {
        return teacher;
    }

    @Bindable
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        notifyChange();
    }
}
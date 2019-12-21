package com.example.android_e_learning;

import android.media.Image;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.Serializable;

/*
 * [{"userid":"1","courseId":"001","name":"Wang Hong","photo":"001\\wang.jpg",
 * "telephone":"01051690273","email":"wang@bjtu.edu","description":"android teacher"}]
 */

public class Teacher extends BaseObservable implements Serializable {
    private String userId;
    private String courseId;
    private String name;
    private String photo;
    private String telephone;
    private String email;
    private String description;

    public Teacher() {
    }

    public Teacher(String userId, String courseId, String name, String photo, String telephone,
                   String email, String description) {

        this.userId = userId;
        this.courseId = courseId;
        this.name = name;
        this.photo = photo;
        this.telephone = telephone;
        this.email = email;
        this.description = description;

    }

    @Bindable
    public String getUserId() {
        return userId;
    }

    @Bindable
    public String getCourseId() {
        return courseId;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getPhoto() {
        return photo;
    }

    @Bindable
    public String getTelephone() {
        return telephone;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public void setUserId(String userId) {
        this.userId = userId;
        notifyChange();
    }

    @Bindable
    public void setCourseId(String courseId) {
        this.courseId = courseId;
        notifyChange();
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        notifyChange();
    }

    @Bindable
    public void setPhoto(String photo) {
        this.photo = photo;
        notifyChange();
    }

    @Bindable
    public void setTelephone(String telephone) {
        this.telephone = telephone;
        notifyChange();
    }

    @Bindable
    public void setEmail(String email) {
        this.email = email;
        notifyChange();
    }

    @Bindable
    public void setDescription(String description) {
        this.description = description;
        notifyChange();
    }
}

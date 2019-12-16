package com.example.android_e_learning;

import android.media.Image;

/*
 * [{"userid":"1","courseId":"001","name":"Wang Hong","photo":"001\\wang.jpg",
 * "telephone":"01051690273","email":"wang@bjtu.edu","description":"android teacher"}]
 */

public class Teacher {
    private String userId;
    private String courseId;
    private String name;
    private Image photo;
    private String telephone;
    private String email;
    private String description;

    public Teacher() {
    }

    public Teacher(String userId, String courseId, String name, Image photo, String telephone,
                   String email, String description) {

        this.userId = userId;
        this.courseId = courseId;
        this.name = name;
        this.photo = photo;
        this.telephone = telephone;
        this.email = email;
        this.description = description;

    }

    public String getUserId() {
        return userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Image getPhoto() {
        return photo;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

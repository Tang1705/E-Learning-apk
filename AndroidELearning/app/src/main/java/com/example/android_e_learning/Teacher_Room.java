package com.example.android_e_learning;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Teacher_Room {
    @NonNull
    @PrimaryKey
    private String userId;

    @ColumnInfo(name = "courseId")
    private String courseId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "photo")
    private String photo;

    @ColumnInfo(name = "telephone")
    private String telephone;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "description")
    private String description;

    public String getUserId() {
        return userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
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

    public void setPhoto(String photo) {
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

    public Teacher_Room(String userId, String courseId, String name, String photo, String telephone,
                   String email, String description) {

        this.userId = userId;
        this.courseId = courseId;
        this.name = name;
        this.photo = photo;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
    }
}

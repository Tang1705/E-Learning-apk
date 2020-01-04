package com.example.android_e_learning;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Course_Room {
    @NonNull
    @PrimaryKey
    private String id;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "categoryId")
    private String categoryId;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "price")
    private int price;

    @ColumnInfo(name = "status")
    private int status;

    @ColumnInfo(name = "openDate")
    private String openDate;

    @ColumnInfo(name = "lastUpdate")
    private String lastUpdate;

    @ColumnInfo(name = "level")
    private int level;

    @ColumnInfo(name = "shared")
    private int shared;

    @ColumnInfo(name = "sharedUrl")
    private String sharedUrl;

    @ColumnInfo(name = "avatar")
    private String avatar;

    @ColumnInfo(name = "bigAvatar")
    private String bigAvatar;

    @ColumnInfo(name = "certification")
    private String certification;

    @ColumnInfo(name = "certificationDuration")
    private String certificationDuration;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getShared() {
        return shared;
    }

    public void setShared(int shared) {
        this.shared = shared;
    }

    public String getSharedUrl() {
        return sharedUrl;
    }

    public void setSharedUrl(String sharedUrl) {
        this.sharedUrl = sharedUrl;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBigAvatar() {
        return bigAvatar;
    }

    public void setBigAvatar(String bigAvatar) {
        this.bigAvatar = bigAvatar;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getCertificationDuration() {
        return certificationDuration;
    }

    public void setCertificationDuration(String certificationDuration) {
        this.certificationDuration = certificationDuration;
    }



    public Course_Room(int type,String id, String name, String code, String categoryId, String description, int price,
                       int status, String openDate, String lastUpdate, int level, int shared, String sharedUrl, String avatar,
                       String bigAvatar, String certification, String certificationDuration) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryId = categoryId;
        this.description = description;
        this.price = price;
        this.status = status;
        this.openDate = openDate;
        this.lastUpdate = lastUpdate;
        this.level = level;
        this.shared = shared;
        this.sharedUrl = sharedUrl;
        this.avatar = avatar;
        this.bigAvatar = bigAvatar;
        this.certification = certification;
        this.certificationDuration = certificationDuration;
    }
}

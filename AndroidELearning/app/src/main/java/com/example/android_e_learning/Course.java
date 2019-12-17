package com.example.android_e_learning;

/*
 * {"id":"001","name":"Android Development","code":"2019SSE_001","categoryId":"ICT_SW_001",
 * "description":"A course for basic android appication development","price":"0","status":"Open",
 * "openDate":"2019-09-01T00:00:00.000+0000","lastUpdateOn":"2019-11-25T09:01:20.000+0000",
 * "level":"basic","shared":"0","sharedUrl":null,"avatar":"001\\av001.jpg","bigAvatar":null,
 * "certification":"BJTU","certificationDuration":"Forever"}
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    public static final int FIRST_TYPE = 0;
    public static final int SECOND_TYPE = 1;

    private int type;

    private String id;
    private String name;
    private String code;
    private String categoryId;
    private String description;
    private int price;
    private int status;
    private String openDate;
    private String lastUpdate;
    private int level;
    private int shared;
    private String sharedUrl;
    private String avatar;
    private String bigAvatar;
    private String certification;
    private String certificationDuration;
    private ArrayList<Teacher> arrayList;
    private ArrayList<Material> mArrayList;

    public Course(int type) {
        arrayList = new ArrayList<Teacher>();

    }


    public Course(int type, String id, String name, String code, String categoryId, String description, int price,
                  int status, String openDate, String lastUpdate, int level, int shared, String sharedUrl, String avatar,
                  String bigAvatar, String certification, String certificationDuration, ArrayList<Teacher> arrayList,
                  ArrayList<Material> mArrayList) {
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
        this.arrayList = arrayList;
        this.mArrayList=mArrayList;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<Teacher> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Teacher> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<Material> getmArrayList() {
        return mArrayList;
    }

    public void setmArrayList(ArrayList<Material> mArrayList) {
        this.mArrayList = mArrayList;
    }
}

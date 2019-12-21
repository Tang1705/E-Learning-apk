package com.example.android_e_learning;

/*
 * {"id":"001","name":"Android Development","code":"2019SSE_001","categoryId":"ICT_SW_001",
 * "description":"A course for basic android appication development","price":"0","status":"Open",
 * "openDate":"2019-09-01T00:00:00.000+0000","lastUpdateOn":"2019-11-25T09:01:20.000+0000",
 * "level":"basic","shared":"0","sharedUrl":null,"avatar":"001\\av001.jpg","bigAvatar":null,
 * "certification":"BJTU","certificationDuration":"Forever"}
 */

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.Serializable;
import java.util.ArrayList;

public class Course extends BaseObservable implements Serializable {
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
        this.mArrayList = mArrayList;

    }

    @Bindable
    public String getId() {
        return id;
    }

    @Bindable
    public void setId(String id) {
        this.id = id;
        notifyChange();
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        notifyChange();
    }

    @Bindable
    public String getCode() {
        return code;
    }

    @Bindable
    public void setCode(String code) {
        this.code = code;
        notifyChange();
    }

    @Bindable
    public String getCategoryId() {
        return categoryId;
    }

    @Bindable
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        notifyChange();
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public void setDescription(String description) {
        this.description = description;
        notifyChange();
    }

    @Bindable
    public int getPrice() {
        return price;
    }

    @Bindable
    public void setPrice(int price) {
        this.price = price;
        notifyChange();
    }

    @Bindable
    public int getStatus() {
        return status;
    }

    @Bindable
    public void setStatus(int status) {
        this.status = status;
        notifyChange();
    }

    @Bindable
    public String getOpenDate() {
        return openDate;
    }

    @Bindable
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
        notifyChange();
    }

    @Bindable
    public String getLastUpdate() {
        return lastUpdate;
    }

    @Bindable
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
        notifyChange();
    }

    @Bindable
    public int getLevel() {
        return level;
    }

    @Bindable
    public void setLevel(int level) {
        this.level = level;
        notifyChange();
    }

    @Bindable
    public int getShared() {
        return shared;
    }

    @Bindable
    public void setShared(int shared) {
        this.shared = shared;
        notifyChange();
    }

    @Bindable
    public String getSharedUrl() {
        return sharedUrl;
    }

    @Bindable
    public void setSharedUrl(String sharedUrl) {
        this.sharedUrl = sharedUrl;
        notifyChange();
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    @Bindable
    public void setAvatar(String avatar) {
        this.avatar = avatar;
        notifyChange();
    }

    @Bindable
    public String getBigAvatar() {
        return bigAvatar;
    }

    @Bindable
    public void setBigAvatar(String bigAvatar) {
        this.bigAvatar = bigAvatar;
        notifyChange();
    }

    @Bindable
    public String getCertification() {
        return certification;
    }

    @Bindable
    public void setCertification(String certification) {
        this.certification = certification;
        notifyChange();
    }

    @Bindable
    public String getCertificationDuration() {
        return certificationDuration;
    }

    @Bindable
    public void setCertificationDuration(String certificationDuration) {
        this.certificationDuration = certificationDuration;
        notifyChange();
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        notifyChange();
    }

    @Bindable
    public ArrayList<Teacher> getArrayList() {
        return arrayList;
    }

    @Bindable
    public void setArrayList(ArrayList<Teacher> arrayList) {
        this.arrayList = arrayList;
        notifyChange();
    }

    @Bindable
    public ArrayList<Material> getmArrayList() {
        return mArrayList;
    }

    @Bindable
    public void setmArrayList(ArrayList<Material> mArrayList) {
        this.mArrayList = mArrayList;
        notifyChange();
    }
}

package com.example.android_e_learning;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Material_Room {
    @NonNull
    @PrimaryKey
    private String id;

    @ColumnInfo(name = "courseId")
    private String courseId;

    @ColumnInfo(name = "mediaType")
    private int mediaType;

    @ColumnInfo(name = "materialType")
    private String materialType;

    @ColumnInfo(name = "materialUrl")
    private String materialUrl;

    @ColumnInfo(name = "createDate")
    private String createDate;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "status")
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialUrl() {
        return materialUrl;
    }

    public void setMaterialUrl(String materialUrl) {
        this.materialUrl = materialUrl;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Material_Room(String id, String courseId, int mediaType, String materialType,
                    String materialUrl, String createDate, String description, int status) {
        this.id = id;
        this.courseId = courseId;
        this.mediaType = mediaType;
        this.materialType = materialType;
        this.materialUrl = materialUrl;
        this.createDate = createDate;
        this.description = description;
        this.status = status;
    }

}

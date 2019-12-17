package com.example.android_e_learning;

/*
 * [{"id":"1","courseId":"001","mediatype":"video","materialType":"lecture video",
 * "materialUrl":"001\\vtest.mp4","createDate":"2019-12-04T22:06:49.000+0000",
 * "description":null,"status":"1"}
 */

import java.io.Serializable;
import java.util.Date;

public class Material implements Serializable {
    private String id;
    private String courseId;
    private int mediaType;
    private String materialType;
    private String materialUrl;
    private String createDate;
    private String description;
    private int status;

    public Material() {
    }

    public Material(String id, String courseId, int mediaType, String materialType,
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
}

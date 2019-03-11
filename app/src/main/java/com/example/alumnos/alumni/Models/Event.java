package com.example.alumnos.alumni.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;


    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("lat")
    @Expose
        private String lat;


    @SerializedName("lon")
    @Expose
    private String lon;


    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("id_user")
    @Expose
    private Integer id_user;

    @SerializedName("id_type")
    @Expose
    private Integer id_type;


    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    public Event(Integer id, String title, String description, String image, String lat, String lon, String date, String url, Integer id_user, Integer id_type, String created_at, String updated_at) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.lat = lat;
        this.lon = lon;
        this.date = date;
        this.url = url;
        this.id_user = id_user;
        this.id_type = id_type;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}

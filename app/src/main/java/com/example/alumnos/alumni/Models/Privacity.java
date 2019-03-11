package com.example.alumnos.alumni.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Privacity {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("phone")
    @Expose
    private Integer phone;

    @SerializedName("location")
    @Expose
    private Integer location;

}

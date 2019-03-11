package com.example.alumnos.alumni.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notas {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("asignatura")
    @Expose
    private String asignatura;

    @SerializedName("comentario")
    @Expose
    private String comentario;


    @SerializedName("nota")
    @Expose
    private String nota;

    @SerializedName("id_user")
    @Expose
    private Integer id_user;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    public Notas(Integer id, String asignatura, String comentario, String nota, Integer id_user, String created_at, String updated_at) {
        this.id = id;
        this.asignatura = asignatura;
        this.comentario = comentario;
        this.nota = nota;
        this.id_user = id_user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
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

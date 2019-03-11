package com.example.alumnos.alumni.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {


    //Login.........
    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("privacity")
    @Expose
    private Privacity privacity ;

    //......................

    //Objeto eventos.......
    @SerializedName("event")
    @Expose
    //private Event event ;
    private List<Event> event;
//.....................
    //Objeto comentario.....
    @SerializedName("comments")
    @Expose
    private List<Comments> comments;

    @SerializedName("nota")
    @Expose
    //private Event event ;
    private List<Notas> nota;

    //LoginGetterAndSetter.........

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Privacity getPrivacity() {
        return privacity;
    }

    public void setPrivacity(Privacity privacity) {
        this.privacity = privacity;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


// Respuesta Lista de eventos. Getter and Setter .........

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

//........................

// Respuesta Lista de comentarios. Getter and Setter ...........


    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }



    // Respuesta Lista de eventos. Getter and Setter .........

    public List<Notas> getNota() {
        return nota;
    }

    public void setNota(List<Notas> nota) {
        this.nota = nota;
    }
}


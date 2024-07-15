package com.aluracursos.forohub.model;


import jakarta.persistence.Entity;

@Entity
public abstract
class Post {
    private String title;
    private String content;

    public
    Post ( ) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
package com.wildcodeschool.sharemybrain;

import java.util.Date;

public class Question {
    private int idQuestion;
    private String title;
    private String description;
    private Date date;
    private int idUser;
    private int idSkill;

    // Empty constructor
    public Question() {
    }

    //Constructor with all items
    public Question(int id, String title, String description, int idUser, int idSkill, Date date) {
        this.idQuestion = id;
        this.title = title;
        this.description = description;
        this.idUser = idUser;
        this.idSkill = idSkill;
        this.date = date;
    }

    public int getIdQuestion() { return this.idQuestion; }

    public void setIdQuestion(int id) { this.idQuestion = id; }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSkill() {
        return this.idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

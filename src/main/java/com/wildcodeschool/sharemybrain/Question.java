package com.wildcodeschool.sharemybrain;

import java.util.Date;

public class Question {
    private String title;
    private String description;
    private Date date;
    private int id_user;
    private int id_skill;

    // Empty constructor
    public Question(){
    }

    //Constructor with all items
    public Question(String title, String description, int id_user, int id_skill, Date date) {
        this.title = title;
        this.description = description;
        this.id_user = id_user;
        this.id_skill = id_skill;
        this.date = date;
    }

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

    public int getId_user() {
        return this.id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_skill() {
        return this.id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package com.wildcodeschool.sharemybrain.entity;

import java.util.Date;

public class Answer {
    private int idAnswer;
    private int idQuestion;
    private int idUser;
    private String description;
    private Date date;

    public Answer(int idAnswer, int idQuestion, int idUser, String answerText, Date date) {
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
        this.idUser = idUser;
        this.description = answerText;
        this.date = date;
    }

    public int getIdAnswer() { return this.idAnswer; }

    public void setIdAnswer(int idAnswer) { this.idAnswer = idAnswer; }

    public int getIdQuestion() { return this.idQuestion; }

    public void setIdQuestion(int idQuestion) { this.idQuestion = idQuestion; }

    public int getIdUser() { return this.idUser; }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return this.date; }

    public void setDate(Date date) { this.date = date; }

}



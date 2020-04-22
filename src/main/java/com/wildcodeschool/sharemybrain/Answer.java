package com.wildcodeschool.sharemybrain;

import java.util.Date;

public class Answer {
    private String questionTitle;
    private String description;
    private Date date;
    private int idUser;
    private int idSkill;
    private int qualityScore; /*attribute for voting for the best answer*/

    public Answer(String questionTitle, String answerText, int idUser, int idSkill, Date date) {
        this.questionTitle = questionTitle;
        this.description = answerText;
        this.idUser = idUser;
        this.idSkill = idSkill;
        this.date = date;
        this.qualityScore = 0;
    }

    public String getQuestionTitle() { return this.questionTitle; }

    public void setQuestionTitle(String questionTitle) { this.questionTitle = questionTitle; }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return this.date; }

    public void setDate(Date date) { this.date = date; }

    public int getIdUser() { return this.idUser; }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSkill() {
        return this.idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    public int getQualityScore() { return this.qualityScore; }

    public void setQualityScore(int score) { this.qualityScore = score; }
}



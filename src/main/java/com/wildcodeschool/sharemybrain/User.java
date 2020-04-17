package com.wildcodeschool.sharemybrain;

public class User {
    private String name;
    private String mail;
    private String pwd;
    private String avatar;
    private String skill;

    // constructeur vide
    public User(){
    }
    //contructeur avec tous les item
    public User(String name, String mail, String pwd, String avatar, String skill) {
        this.name = name;
        this.mail = mail;
        this.pwd = pwd;
        this.avatar = avatar;
        this.skill = skill;
    }
    // constructeur sans skill
    public User(String name, String mail, String pwd, String avatar) {
        this.name = name;
        this.mail = mail;
        this.pwd = pwd;
        this.avatar = avatar;
    }
    // getters
    public String getName() {
        return name;
    }
    public String getMail() {
        return mail;
    }
    public String getPwd() {
        return pwd;
    }
    public String getAvatar() {
        return avatar;
    }
    public String getSkill() {
        return skill;
    }
    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }
}
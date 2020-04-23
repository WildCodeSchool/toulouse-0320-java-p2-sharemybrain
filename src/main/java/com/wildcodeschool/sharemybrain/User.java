package com.wildcodeschool.sharemybrain;

public class User {
    private int idUser;
    private String name;
    private String mail;
    private String pwd;
    private String avatar;
    private String skill;

    // Empty constructor
    public User(){
    }

    //Constructor with all items
    public User(int id, String name, String mail, String pwd, String avatar, String skill) {
        this.idUser = id;
        this.name = name;
        this.mail = mail;
        this.pwd = pwd;
        this.avatar = avatar;
        this.skill = skill;
    }

    // Constructor without skill
    public User(int id, String name, String mail, String pwd, String avatar) {
        this.idUser = id;
        this.name = name;
        this.mail = mail;
        this.pwd = pwd;
        this.avatar = avatar;
    }

    // getters
    public int getIdUser() { return idUser; }
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
    public void setIdUser(int id) { this.idUser = id; }
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
package com.wildcodeschool.sharemybrain.entity;

public class User {
    private int idUser;
    private String userName;
    private String mail;
    private String pwd;
    private int idAvatar;
    private int idSkill;

    // Empty constructor
    public User(){
    }

    //Constructor without id
    public User(String userName, String mail, String pwd, int idAvatar, int idSkill) {
        this.userName = userName;
        this.mail = mail;
        this.pwd = pwd;
        this.idAvatar = idAvatar;
        this.idSkill = idSkill;
    }

    //Constructor with all items
    public User(int id, String userName, String mail, String pwd, int idAvatar, int idSkill) {
        this.idUser = id;
        this.userName = userName;
        this.mail = mail;
        this.pwd = pwd;
        this.idAvatar = idAvatar;
        this.idSkill = idSkill;
    }

    // Constructor without idSkill
    public User(int id, String userName, String mail, String pwd, int idAvatar) {
        this.idUser = id;
        this.userName = userName;
        this.mail = mail;
        this.pwd = pwd;
        this.idAvatar = idAvatar;
    }

    // getters
    public int getIdUser() { return idUser; }
    public String getUserName() {
        return userName;
    }
    public String getMail() {
        return mail;
    }
    public String getPwd() {
        return pwd;
    }
    public int getIdAvatar() {
        return idAvatar;
    }
    public int getIdSkill() {
        return idSkill;
    }

    // setters
    public void setIdUser(int id) { this.idUser = id; }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }
    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }
}
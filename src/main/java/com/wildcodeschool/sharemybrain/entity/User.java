package com.wildcodeschool.sharemybrain.entity;

public class User {
    private int idUser;
    private String userName;
    private String mail;
    private String pwd;
    private int idAvatar;
    private int idSkill;
    private String pwd2;

    // Empty constructor
    public User(){
    }

    //Constructor without id and with pwd2
    public User(String userName, String mail, String pwd, int idSkill, String pwd2, int idAavatar) {
        this.userName = userName;
        this.mail = mail;
        this.pwd = pwd;
        this.idSkill = idSkill;
        this.pwd2 = pwd2;
        this.idAvatar = idAavatar;
    }

    //Constructor without pwd2
    public User(int id, String userName, String mail, String pwd, int idAvatar, int idSkill) {
        this.idUser = id;
        this.userName = userName;
        this.mail = mail;
        this.pwd = pwd;
        this.idAvatar = idAvatar;
        this.idSkill = idSkill;
    }

    // Constructor without idSkill and pwd2
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
    public String getPwd2() {
        return pwd2;
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
    public void setPwd2(String pwd2) {
        this.pwd2 = pwd2;
    }
}
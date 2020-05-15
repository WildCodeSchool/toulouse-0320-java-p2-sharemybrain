package com.wildcodeschool.sharemybrain.entity;

public class Avatar {
    private int id;
    private String url;

    public Avatar() {}

    public Avatar(String url) {
        this.url = url;
    }

    public Avatar(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

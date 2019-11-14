package com.iamjosephvarghese.firebaseworkshop;

public class Quote {

    String data;
    String author;


    public Quote(String data, String author) {
        this.data = data;
        this.author = author;
    }


    public String getData() {
        return data;
    }

    public String getAuthor() {
        return author;
    }


    public void setData(String data) {
        this.data = data;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

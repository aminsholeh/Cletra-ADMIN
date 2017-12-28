package com.example.aminsholeh.cletraadmin;

import java.io.Serializable;

/**
 * Created by Amin Sholeh on 28-Dec-17.
 */

public class Book implements Serializable {
    private String id;
    private String title;
    private String author;
    private String num;

    public Book() {

    }

    public Book(String id, String title, String author, String num){
        this.id = id;
        this.title = title;
        this.author = author;
        this.num = num;
    }

    public Book(String title, String author, String num){
        this.title = title;
        this.author = author;
        this.num = num;
    }
    @Override
    public String toString(){
        return title+" - "+author+" - "+num+"\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}

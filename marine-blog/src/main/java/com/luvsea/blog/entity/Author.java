package com.luvsea.blog.entity;

import java.sql.Timestamp;

public class Author {

    private Long id ;
    private String name;
    private Timestamp birthDay;
    private int age;
    //作者有所写的文章，必须唯一对应
    private Article article;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Timestamp getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }
        
}

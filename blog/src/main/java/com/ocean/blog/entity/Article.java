package com.ocean.blog.entity;

import java.sql.Timestamp;

import org.codehaus.jackson.annotate.JsonIgnore;

//有refactor的意识，先把Id用在每个类的本身
public class Article {
    
    private Long id;
    
    private String title;
    
    private String content;

    private int status;
    
    private Timestamp createTime;
    
    private Timestamp updateTime;
    
    //每个文章，都有一个唯一对应的作者
    @JsonIgnore
    private Author author;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    
}

package com.ocean.blog.service;

import java.util.List;

import com.ocean.blog.entity.Article;

public interface ArticleService {

    public List<Article> articleList(Article article);
    
    //add
    public long addArticle(Article article);
}

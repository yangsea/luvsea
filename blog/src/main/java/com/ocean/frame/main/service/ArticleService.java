package com.ocean.frame.main.service;

import java.util.List;

import com.ocean.frame.main.entity.Article;

public interface ArticleService {

    public List<Article> articleList(Article article);
    
    //add
    public long addArticle(Article article);
}

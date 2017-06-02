package com.luvsea.blog.service;

import java.util.List;

import com.luvsea.blog.entity.Article;

public interface ArticleService {

    public List<Article> articleList(Article article);
    
    //add
    public long addArticle(Article article);
}

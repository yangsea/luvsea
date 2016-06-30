package com.ocean.main.dao;

import java.util.List;

import com.ocean.main.entity.Article;

public interface ArticleDao {

    public List<Article> articleList(Article article);
    //add
    public long addArticle(Article article);
}

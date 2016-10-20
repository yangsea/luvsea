package com.ocean.blog.dao.article;

import java.util.List;

import com.ocean.blog.entity.Article;

public interface ArticleDao {

    public List<Article> articleList(Article article);
    //add
    public long addArticle(Article article);
}

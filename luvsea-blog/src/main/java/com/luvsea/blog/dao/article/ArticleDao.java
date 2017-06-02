package com.luvsea.blog.dao.article;

import java.util.List;

import com.luvsea.blog.entity.Article;

public interface ArticleDao {

    public List<Article> articleList(Article article);
    //add
    public long addArticle(Article article);
}

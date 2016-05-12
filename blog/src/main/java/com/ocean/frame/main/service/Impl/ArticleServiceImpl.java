package com.ocean.frame.main.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocean.frame.main.dao.ArticleDao;
import com.ocean.frame.main.entity.Article;
import com.ocean.frame.main.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    
    @Override
    public List<Article> articleList(Article article) {

        return null;
    }

    @Override
    public long addArticle(Article article) {

        long articleId = articleDao.addArticle(article);
        return articleId;
    }
    

}

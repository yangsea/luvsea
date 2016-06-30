package com.ocean.main.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocean.main.dao.ArticleDao;
import com.ocean.main.entity.Article;
import com.ocean.main.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Article> articleList(Article article) {

    	List<Article> articleList = articleDao.articleList(article);
    	for (Article article2 : articleList) {
			System.out.println("内容"+article2.getContent());
		}
        return articleList;
    }

    @Override
    public long addArticle(Article article) {

        long articleId = articleDao.addArticle(article);
        return articleId;
    }
    

}

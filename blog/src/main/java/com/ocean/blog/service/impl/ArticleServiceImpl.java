package com.ocean.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocean.blog.dao.article.ArticleDao;
import com.ocean.blog.entity.Article;
import com.ocean.blog.entity.Author;
import com.ocean.blog.service.ArticleService;

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
			Author au =  article2.getAuthor();
			String name = au.getName();
			System.out.println("作者姓名：##############################3"+name);
		}
        return articleList;
    }

    @Override
    public long addArticle(Article article) {

        long articleId = articleDao.addArticle(article);
        return articleId;
    }
    

}

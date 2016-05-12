package com.ocean.frame.main.dao.Impl;

import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ocean.frame.main.common.BaseHibernateTemplate;
import com.ocean.frame.main.dao.ArticleDao;
import com.ocean.frame.main.entity.Article;

//@Component
@Repository
public class ArticleDaoImpl extends BaseHibernateTemplate implements ArticleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Article> articleList(Article article) {
        
        List<Article> articleList = this.getHibernateTemplate().find(" From Article ");
        return articleList;
    }

    @Override
    public long addArticle(Article article) {
        
        this.getHibernateTemplate().save(article);
        return article.getId();
    }
    
    

}

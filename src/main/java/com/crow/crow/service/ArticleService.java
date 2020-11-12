package com.crow.crow.service;

import com.crow.crow.dao.ArticleDao;
import com.crow.crow.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleService(@Qualifier("postgres") ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public int addArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    public List<Article> getAllArticles() {
        return articleDao.selectAllArticles();
    }
}
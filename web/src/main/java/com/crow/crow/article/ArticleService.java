package com.crow.crow.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleDataAccessService articleDataAccessService;

    @Autowired
    public ArticleService(ArticleDataAccessService articleDataAccessService) {
        this.articleDataAccessService = articleDataAccessService;
    }

    public List<Article> getAllArticles() {
        return articleDataAccessService.selectAllArticles();
    }

    public List<Article> getArticlesByX(String x, String y) {
        return articleDataAccessService.getArticlesByX(x, y);
    }
}
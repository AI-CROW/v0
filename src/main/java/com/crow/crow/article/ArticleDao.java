package com.crow.crow.article;

import com.crow.crow.article.Article;

import java.util.List;
import java.util.UUID;

public interface ArticleDao {

    int insertArticle(UUID id, Article article);

    default int insertArticle(Article article) {
        UUID id = UUID.randomUUID();
        return insertArticle(id, article);
    }

    List<Article> selectAllArticles();
}


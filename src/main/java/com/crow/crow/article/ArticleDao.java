package com.crow.crow.article;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleDao {

    int insertArticle(UUID id, Article article);

    default int insertArticle(Article article) {
        UUID id = UUID.randomUUID();
        return insertArticle(id, article);
    }

    List<Article> getArticlesByX(String x, String y);
    List<Article> selectAllArticles();
}


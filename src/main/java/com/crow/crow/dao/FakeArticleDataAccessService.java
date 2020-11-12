package com.crow.crow.dao;

import com.crow.crow.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeArticleDataAccessService implements ArticleDao {

    private static List<Article> DB = new ArrayList<>();

    @Override
    public int insertArticle(UUID id, Article article) {
        DB.add(new Article(id, article.getTitle()));
        return 1;
    }

    @Override
    public List<Article> selectAllArticles() {
        return DB;
    }
}

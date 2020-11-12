package com.crow.crow.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class ArticleDataAccessService implements ArticleDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertArticle(UUID id, Article article) {
        return 0;
    }

    @Override
    public List<Article> selectAllArticles() {
        final String sql = "SELECT id, title, author, postDate, content, url FROM article";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String postDate = resultSet.getString("postDate");
            String content = resultSet.getString("content");
            String url = resultSet.getString("url");
            return new Article(id, title, author, postDate, content, url);
        });
    }
}

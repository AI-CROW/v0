package com.crow.crow.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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
        final String sql = "INSERT INTO article(id, title, author, postDate, content, url) VALUES (uuid_generate_v4(), ?, ?, ?, ?, ?);";
        jdbcTemplate.update(
                sql,
                article.getTitle(), article.getAuthor(), article.getPostDate(), article.getContent(), article.getUrl()
        );
        return 0;
    }

    @Override
    public List<Article> getArticlesByX(String x, String y) {
        final String sql = "SELECT id, title, author, publisher, postDate, content, url FROM article WHERE " + x + " = '" + y + "'";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author_ = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            String postDate = resultSet.getString("postDate");
            String content = resultSet.getString("content");
            String url = resultSet.getString("url");
            return new Article(id, title, author_, publisher, postDate, content, url);
        });
    }

    @Override
    public List<Article> selectAllArticles() {
        final String sql = "SELECT id, title, author, publisher, postDate, content, url FROM article";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            String postDate = resultSet.getString("postDate");
            String content = resultSet.getString("content");
            String url = resultSet.getString("url");
            return new Article(id, title, author, publisher, postDate, content, url);
        });
    }
}

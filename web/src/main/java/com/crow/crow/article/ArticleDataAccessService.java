package com.crow.crow.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

@Repository
public class ArticleDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertArticle(Article article) {
        final String sql = "INSERT INTO article(id, title, author, postDate, content, url, site_id, author_id) VALUES (uuid_generate_v4(), ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(
                sql,
                article.getTitle(), article.getAuthor(), article.getPostDate(), article.getContent(), article.getUrl(), article.getSite_id(), article.getAuthor_id()
        );
        return 0;
    }

    public boolean exists(String title) {
        final String sql = "SELECT 1 FROM article WHERE title = ?";
        boolean exists =
            jdbcTemplate
                .query(sql,
                    new Object[]{title},
                    (ResultSet rs) -> {
                        if (rs.next()) {
                            return true;
                        }
                        return false;
                    }
                );
        return exists;
    }

    public List<Article> selectAllArticles() {
        final String sql = "SELECT id, title, author, postDate, content, url, site_id, author_id FROM article";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String postDate = resultSet.getString("postDate");
            String content = resultSet.getString("content");
            String url = resultSet.getString("url");
            UUID site_id = UUID.fromString(resultSet.getString("site_id"));
            UUID author_id = UUID.fromString(resultSet.getString("author_id"));
            return new Article(id, title, author, postDate, content, url, site_id, author_id);
        });
    }

    public List<Article> getArticlesByX(String x, String y) {
        final String sql = "SELECT id, title, author, postDate, content, url, site_id, author_id FROM article WHERE " + x + " = '" + y + "'";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String postDate = resultSet.getString("postDate");
            String content = resultSet.getString("content");
            String url = resultSet.getString("url");
            UUID site_id = UUID.fromString(resultSet.getString("site_id"));
            UUID author_id = UUID.fromString(resultSet.getString("author_id"));
            return new Article(id, title, author, postDate, content, url, site_id, author_id);
        });
    }
}

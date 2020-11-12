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
        final String sql = "INSERT INTO article(id, title, postDate, content, url, site_id, author_id) VALUES (uuid_generate_v4(), ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(
                sql,
                article.getTitle(), article.getPostDate(), article.getContent(), article.getUrl(), article.getSite_id(), article.getAuthor_id()
        );
        return 0;
    }

    @Override
    public List<Article> getArticlesByX(String x, String y) {
        final String sql = "SELECT id, title, postDate, content, url, site_id, author_id FROM article WHERE " + x + " = '" + y + "'";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String postDate = resultSet.getString("postDate");
            String content = resultSet.getString("content");
            String url = resultSet.getString("url");
            UUID site_id = UUID.fromString(resultSet.getString("site_id"));
            UUID author_id = UUID.fromString(resultSet.getString("author_id"));
            return new Article(id, title, postDate, content, url, site_id, author_id);
        });
    }

    @Override
    public List<Article> selectAllArticles() {
        final String sql = "SELECT id, title, postDate, content, url, site_id, author_id FROM article";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String postDate = resultSet.getString("postDate");
            String content = resultSet.getString("content");
            String url = resultSet.getString("url");
            UUID site_id = UUID.fromString(resultSet.getString("site_id"));
            UUID author_id = UUID.fromString(resultSet.getString("author_id"));
            return new Article(id, title, postDate, content, url, site_id, author_id);
        });
    }
}

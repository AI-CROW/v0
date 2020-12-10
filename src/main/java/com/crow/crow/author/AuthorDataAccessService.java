package com.crow.crow.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AuthorDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDataAccessService(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public int addAuthor(Author author) {
        final String sql = "INSERT INTO author(id, name, accuracy) VALUES (uuid_generate_v4(), ?, ?);";
        jdbcTemplate.update(
                sql,
                author.getName(), author.getAccuracy()
        );
        return 0;
    }

    public int insertAuthor(UUID id, Author author) {
        final String sql = "INSERT INTO author(id, name, accuracy) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                id, author.getName(), author.getAccuracy()
        );
        return 0;
    }

    public List<Author> selectAllAuthors() {
        final String sql = "SELECT id, name, accuracy FROM author";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            Double accuracy = resultSet.getDouble("accuracy");
            return new Author(id, name, accuracy);
        });
    }

    public List<Author> getAuthorsByX(String x, String y) {
        final String sql = "SELECT id, name, accuracy FROM author WHERE " + x + " = '" + y + "'";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            Double accuracy = resultSet.getDouble("accuracy");
            return new Author(id, name, accuracy);
        });
    }
}

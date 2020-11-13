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

    public List<Author> selectAllAuthors() {
        final String sql = "SELECT id, name, accuracy FROM author";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String accuracy = resultSet.getString("accuracy");
            return new Author(id, name, accuracy);
        });
    }

    public List<Author> getAuthorsByX(String x, String y) {
        final String sql = "SELECT id, name, accuracy FROM author WHERE " + x + " = '" + y + "'";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String accuracy = resultSet.getString("accuracy");
            return new Author(id, name, accuracy);
        });
    }
}

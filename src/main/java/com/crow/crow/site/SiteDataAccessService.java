package com.crow.crow.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SiteDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SiteDataAccessService(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public List<Site> selectAllSites() {
        final String sql = "SELECT id, name, url, accuracy FROM site";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");
            String accuracy = resultSet.getString("accuracy");
            return new Site(id, name, url, accuracy);
        });
    }

    public List<Site> getSitesByX(String x, String y) {
        final String sql = "SELECT id, name, url, accuracy FROM site WHERE " + x + " = '" + y + "'";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");
            String accuracy = resultSet.getString("accuracy");
            return new Site(id, name, url, accuracy);
        });
    }
}

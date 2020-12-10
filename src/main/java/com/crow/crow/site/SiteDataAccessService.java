package com.crow.crow.site;

import com.crow.crow.author.Author;
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

    public int insertSite(Site site) {
        final String sql = "INSERT INTO site(id, name, url, accuracy, type) VALUES (uuid_generate_v4(), ?, ?, ?, ?);";
        jdbcTemplate.update(
                sql,
                site.getName(), site.getUrl(), site.getAccuracy(), site.getType()
        );
        return 0;
    }

    public List<Site> selectAllSites() {
        final String sql = "SELECT id, name, url, accuracy, type FROM site";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");
            String accuracy = resultSet.getString("accuracy");
            String type = resultSet.getString("type");
            return new Site(id, name, url, accuracy, type);
        });
    }

    public List<Site> getSitesByX(String x, String y) {
        final String sql = "SELECT id, name, url, accuracy, type FROM site WHERE " + x + " = '" + y + "'";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");
            String accuracy = resultSet.getString("accuracy");
            String type = resultSet.getString("type");
            return new Site(id, name, url, accuracy, type);
        });
    }
}

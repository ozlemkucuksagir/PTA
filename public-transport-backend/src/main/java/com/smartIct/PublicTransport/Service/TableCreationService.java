package com.smartIct.PublicTransport.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableCreationService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TableCreationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        String sql = "CREATE TABLE deneme_users (" +
                "id SERIAL PRIMARY KEY," +
                "username VARCHAR(50) NOT NULL," +
                "email VARCHAR(100) NOT NULL" +
                ")";
        jdbcTemplate.execute(sql);
    }
}

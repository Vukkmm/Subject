package com.example.Subject.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariConfiguration {

    private static HikariConfiguration instance = new HikariConfiguration();

    // để ko thể tạo ra các instance tuf bên ngoài
    private HikariConfiguration() {};

    public static HikariConfiguration getInstance() {
        if(instance ==  null) {
            instance = new HikariConfiguration();
        }
        return instance;
    }
    static {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/Subject");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("123456");
        hikariConfig.setAutoCommit(false);
        hikariConfig.setPoolName("pool");
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setConnectionTimeout(20000);
        hikariDataSource = new HikariDataSource(hikariConfig);
    }
    private static HikariDataSource hikariDataSource;
    public Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }



}

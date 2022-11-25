package com.mvc_hw.config;

import com.mvc_hw.dao.TaskJdbcDao;
import com.mvc_hw.dao.TasksListJdbcDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcDaoContextConfiguration {
    @Bean
    public TaskJdbcDao taskJdbcDao(DataSource dataSource) {
        return new TaskJdbcDao(dataSource);
    }

    @Bean
    TasksListJdbcDao tasksListJdbcDao(DataSource dataSource) {
        return new TasksListJdbcDao(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:task.db");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }
}

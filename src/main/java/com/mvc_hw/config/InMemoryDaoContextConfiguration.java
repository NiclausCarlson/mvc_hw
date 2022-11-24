package com.mvc_hw.config;

import com.mvc_hw.dao.TaskDao;
import com.mvc_hw.dao.TaskInMemoryDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class InMemoryDaoContextConfiguration {
    @Bean
    public TaskDao productDao() {
        return new TaskInMemoryDao();
    }
}

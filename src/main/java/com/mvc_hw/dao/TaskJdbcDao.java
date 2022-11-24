package com.mvc_hw.dao;

import com.mvc_hw.model.Task;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskJdbcDao extends JdbcDaoSupport implements TaskDao {
    private final AtomicInteger lastId = new AtomicInteger(0);

    public TaskJdbcDao(DataSource dataSource) {
        super();
        setDataSource(dataSource);
    }

    @Override
    public List<Task> getTasks() {
        String sql = "select * from Tasks";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Task.class));
    }

    @Override
    public int addTask(Task task) {
        String sql = "insert into Tasks (Id, Name, Description, Priority, IsDone) " +
                "values (?,?,?,?,?)";
        var id = lastId.incrementAndGet();
        task.setId(id);
        return getJdbcTemplate().update(sql, id, task.getName(),
                task.getDescription(), task.getPriority(), task.isDone());
    }
}

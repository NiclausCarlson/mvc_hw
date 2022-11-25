package com.mvc_hw.dao;

import com.mvc_hw.model.Task;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskJdbcDao extends JdbcDaoSupport implements TaskDao {
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
        String sql = "insert into Tasks (Name, Description, Priority, IsDone) " +
                "values (?,?,?,?)";
        return getJdbcTemplate().update(sql, task.getName(),
                task.getDescription(), task.getPriority(), task.isDone());
    }

    @Override
    public void deleteTask(Integer id) {
        String sql = "delete from Tasks where Id = ?";
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public void updateTask(Integer id,
                           Optional<Integer> newPriority,
                           Optional<Boolean> isDone,
                           Optional<String> newName,
                           Optional<String> newDescription) {
        newPriority.ifPresent(s -> updateTaskImpl(id, "priority", s));
        isDone.ifPresent(s -> updateTaskImpl(id, "isDone", s));
        newName.ifPresent(s -> updateTaskImpl(id, "name", s));
        newDescription.ifPresent(s -> updateTaskImpl(id, "description", s));
    }

    private <T> void updateTaskImpl(Integer id, String field, T value) {
        String sql = "update Tasks set " + field + " = ? " + "where id = ?";
        getJdbcTemplate().update(sql, value, id);
    }
}

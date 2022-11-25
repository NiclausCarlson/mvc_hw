package com.mvc_hw.dao;

import com.mvc_hw.model.Task;
import com.mvc_hw.model.TasksList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class TasksListJdbcDao extends JdbcDaoSupport implements TaskListsDao {
    public TasksListJdbcDao(DataSource dataSource) {
        super();
        setDataSource(dataSource);
    }

    @Override
    public List<TasksList> getLists() {
        String sql = "select * from TasksList";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Task.class));
    }

    @Override
    public int addList(TasksList list) {
        String sql = "insert into TasksList (Name) values (?)";
        return getJdbcTemplate().update(sql, list.getName());
    }

    @Override
    public void deleteList(int id) {
        String sql = "delete from TasksList where Id = ?";
        getJdbcTemplate().update(sql, id);
    }
}

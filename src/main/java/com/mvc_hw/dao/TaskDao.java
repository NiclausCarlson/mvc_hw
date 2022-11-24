package com.mvc_hw.dao;

import com.mvc_hw.model.Task;

import java.util.List;

public interface TaskDao {
    List<Task> getTasks();

    int addTask(Task task);
}

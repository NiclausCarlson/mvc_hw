package com.mvc_hw.dao;

import com.mvc_hw.model.TasksList;

import java.util.List;

public interface TaskListsDao {
    List<TasksList> getLists();

    int addList(TasksList list);

    void deleteList(int id);
}

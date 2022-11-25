package com.mvc_hw.dao;

import com.mvc_hw.model.Task;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TaskDao {
    List<Task> getTasks(Integer listId);

    int addTask(Task task);

    void deleteTask(Integer id);

    void updateTask(Integer id, Optional<Integer> new_priority,
                    Optional<Boolean> is_done,
                    Optional<String> new_name,
                    Optional<String> new_description);
}

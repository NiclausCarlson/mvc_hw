package com.mvc_hw.logic;

import com.mvc_hw.model.Task;

import java.util.List;
import java.util.Optional;

public class TaskFilter {
    public static List<Task> getFiltered(List<Task> tasks, Optional<Integer> priority, Optional<Boolean> isDone) {
        return tasks.stream().filter(
                (s) -> {
                    boolean ok1 = true;
                    boolean ok2 = true;
                    if (priority.isPresent()) {
                        ok1 = s.getPriority() == priority.get();
                    }
                    if (isDone.isPresent()) {
                        ok2 = s.isDone() == isDone.get();
                    }
                    return ok1 && ok2;
                }
        ).toList();
    }
}

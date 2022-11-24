package com.mvc_hw.dao;

import com.mvc_hw.model.Task;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskInMemoryDao implements TaskDao{

    private final AtomicInteger lastId = new AtomicInteger(0);
    private final List<Task> products = new CopyOnWriteArrayList<>();

    @Override
    public List<Task> getTasks() {
        return List.copyOf(products);
    }

    @Override
    public int addTask(Task task) {
        var id = lastId.incrementAndGet();
        task.setId(id);
        products.add(task);
        return id;
    }
}

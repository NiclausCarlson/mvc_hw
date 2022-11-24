package com.mvc_hw.model;

public class Task {
    private int id;
    private String name;
    private String description;
    private int priority;

    private boolean isDone;

    public Task() {
        this.priority = 0;
        this.isDone = false;
    }

    public Task(int id, String name, String description, int priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isDone = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

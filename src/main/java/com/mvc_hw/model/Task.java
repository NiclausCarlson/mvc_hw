package com.mvc_hw.model;

public class Task {
    private int id;

    private int listId;
    private String name;
    private String description;
    private int priority;

    private boolean isDone;

    public Task() {
        this.priority = 0;
        this.isDone = false;
    }

    public Task(int id, int listId, String name, String description, int priority, boolean isDone) {
        this.id = id;
        this.listId = listId;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
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

    public void setIsDone(boolean done) {
        isDone = done;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getListId() {
        return listId;
    }
}

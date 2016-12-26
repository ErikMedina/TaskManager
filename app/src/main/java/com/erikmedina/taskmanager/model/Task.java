package com.erikmedina.taskmanager.model;

import io.realm.RealmObject;

/**
 * Created by erik on 18/12/16.
 */

public class Task extends RealmObject {

    private String description;
    private int duration;
    private int type;
    private boolean isCompleted;

    public Task() {
    }

    public Task(String description, int duration, int type) {
        this.description = description;
        this.duration = duration;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

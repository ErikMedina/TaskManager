package com.erikmedina.taskmanager.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by erik on 18/12/16.
 */

public class User extends RealmObject {

    private String username;
    private String password;
    private String userType;
    private RealmList<RealmInteger> taskTypes;
    private RealmList<Task> tasks;

    public User() {
    }

    public User(String username, String password, String userType, List<Integer> taskTypes) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.taskTypes = new RealmList();
        for (Integer integer : taskTypes) {
            this.taskTypes.add(new RealmInteger(integer));
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RealmList<RealmInteger> getTaskTypes() {
        return taskTypes;
    }

    public void setTaskTypes(RealmList<RealmInteger> tasksTypes) {
        this.taskTypes = tasksTypes;
    }

    public RealmList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(RealmList<Task> tasks) {
        this.tasks = tasks;
    }
}

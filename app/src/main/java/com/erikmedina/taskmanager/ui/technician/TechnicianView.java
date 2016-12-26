package com.erikmedina.taskmanager.ui.technician;

import com.erikmedina.taskmanager.model.Task;

import io.realm.RealmList;

/**
 * Created by erik on 21/12/16.
 */

public interface TechnicianView {

    void goToFarmActivity();

    void setTasksList(RealmList<Task> tasks);
}

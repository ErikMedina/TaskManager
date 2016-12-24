package com.erikmedina.taskmanager.domain.interactor.task;

import com.erikmedina.taskmanager.model.Task;

import io.realm.Realm;

/**
 * Created by erik on 23/12/16.
 */
public class CheckIfTaskExistsInteractorImpl implements CheckIfTaskExistsInteractor {

    @Override
    public void execute(String type, OnTaskExistsListener listener) {
        Realm realm = Realm.getDefaultInstance();
        Task task = realm.where(Task.class)
                .equalTo("type", Integer.parseInt(type))
                .findFirst();
        if (task != null) {
            listener.onTaskExistsSuccess(true);
        } else {
            listener.onTaskExistsSuccess(false);
        }
    }
}

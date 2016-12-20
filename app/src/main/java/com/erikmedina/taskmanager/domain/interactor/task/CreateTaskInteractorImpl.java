package com.erikmedina.taskmanager.domain.interactor.task;

import com.erikmedina.taskmanager.model.Task;

import io.realm.Realm;

/**
 * Created by erik on 20/12/16.
 */
public class CreateTaskInteractorImpl implements CreateTaskInteractor {

    @Override
    public void execute(Task task, OnCreateTaskListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealm(task);
            realm.commitTransaction();
            listener.onCreateTaskSuccess();
        } finally {
            realm.close();
        }
    }
}

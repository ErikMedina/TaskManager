package com.erikmedina.taskmanager.domain.interactor.task;

import com.erikmedina.taskmanager.model.Task;

import io.realm.Realm;

/**
 * Created by erik on 26/12/16.
 */
public class CompleteTaskInteractorImpl implements CompleteTaskInteractor {

    @Override
    public void execute(Task task, OnCompleteTaskListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            task.setCompleted(true);
            realm.commitTransaction();
            listener.onCompleteTaskSuccess();

        } finally {
            realm.close();
        }
    }
}

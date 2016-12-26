package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.Task;
import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;

/**
 * Created by erik on 26/12/16.
 */
public class AddTaskToUserInteractorImpl implements AddTaskToUserInteractor {

    @Override
    public void execute(User user, Task task, OnAddTaskToUserListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            user.getTasks().add(task);
            realm.commitTransaction();
            listener.onAddTaskToUserSuccess();
        } finally {
            realm.close();
        }
    }
}

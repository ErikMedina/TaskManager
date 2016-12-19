package com.erikmedina.taskmanager.ui.admin;

import com.erikmedina.taskmanager.model.Task;

import io.realm.Realm;

/**
 * Created by erik on 19/12/16.
 */
public class AdminInteractorImpl implements AdminInteractor {

    @Override
    public void createTask(Task task, OnAdminListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealm(task);
            realm.commitTransaction();
            listener.onAdminSuccess();
        } finally {
            realm.close();
        }
    }
}

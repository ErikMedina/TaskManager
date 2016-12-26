package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;

/**
 * Created by erik on 26/12/16.
 */
public class UpdateUserWorkLoadInteractorImpl implements UpdateUserWorkLoadInteractor {

    @Override
    public void execute(User user, int taskDuration, boolean isSum, OnUpdateUserWorkLoadListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            int workLoad = user.getWorkLoad();
            if (isSum) {
                workLoad += taskDuration;
            } else {
                workLoad -= taskDuration;
            }
            user.setWorkLoad(workLoad);
            realm.commitTransaction();
            listener.onUpdateUserWorkLoadSuccess();
        } finally {
            realm.close();
        }
    }
}

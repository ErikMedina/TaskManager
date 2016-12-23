package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;

/**
 * Created by erik on 23/12/16.
 */
public class CheckIfUserExistsInteractorImpl implements CheckIfUserExistsInteractor {

    @Override
    public void execute(String username, OnUserExistsListener listener) {
        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class)
                .equalTo("username", username)
                .findFirst();
        if (user != null) {
            listener.onUserExistsSuccess(true);
        } else {
            listener.onUserExistsSuccess(false);
        }
    }
}

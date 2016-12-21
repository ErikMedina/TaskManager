package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;

/**
 * Created by erik on 17/12/16.
 */
public class RegisterUserInteractorImpl implements RegisterUserInteractor {

    @Override
    public void persistUser(User user, OnRegisterUserListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealm(user);
            realm.commitTransaction();
            listener.onRegisterUserSuccess(true);
        } finally {
            realm.close();
        }
    }
}

package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;

/**
 * Created by erik on 17/12/16.
 */
public class RegisterUserInteractorImpl implements RegisterUserInteractor {

    @Override
    public void execute(User user, OnRegisterUserListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            int nextId = 0;
            if (realm.where(User.class).max("id") != null) {
                nextId = (realm.where(User.class).max("id").intValue() + 1);
            }
            user.setId(nextId);
            realm.copyToRealm(user);
            realm.commitTransaction();
            listener.onRegisterUserSuccess(true);
        } finally {
            realm.close();
        }
    }
}

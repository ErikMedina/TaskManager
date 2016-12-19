package com.erikmedina.taskmanager.ui.registration;

import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;

/**
 * Created by erik on 17/12/16.
 */
public class RegistrationInteractorImpl implements RegistrationInteractor {

    @Override
    public void persistUser(User user, OnRegistrationListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealm(user);
            realm.commitTransaction();
            listener.onRegistrationSuccess(true);
        } finally {
            realm.close();
        }
    }
}

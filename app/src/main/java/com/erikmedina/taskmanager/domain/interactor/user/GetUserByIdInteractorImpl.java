package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;

/**
 * Created by erik on 26/12/16.
 */
public class GetUserByIdInteractorImpl implements GetUserByIdInteractor {

    @Override
    public void execute(int id, OnGetUserByIdListener listener) {
        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class)
                .equalTo("id", id)
                .findFirst();
        if (user != null) {
            listener.onGetUserByIdSuccess(user);
        }else{
            listener.onGetUserByIdError("There is an error in database");
        }
    }
}

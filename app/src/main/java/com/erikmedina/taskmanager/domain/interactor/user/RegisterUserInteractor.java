package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 17/12/16.
 */

public interface RegisterUserInteractor {

    interface OnRegisterUserListener {

        void onRegisterUserSuccess(boolean isSuccessfulRegistration);

        void onRegisterUserError(String error);
    }

    void persistUser(User user, OnRegisterUserListener listener);
}

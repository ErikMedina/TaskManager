package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 17/12/16.
 */

public interface CheckLoginInteractor {

    interface OnLoginListener {

        void onLoginSuccess(User user);

        void onLoginError(String error);

    }

    void execute(String username, String password, OnLoginListener listener);
}

package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 17/12/16.
 */

public interface LoginInteractor {

    interface OnLoginListener {

        void onLoginSuccess(User user);

        void onLoginError(String error);

    }

    void checkCredentials(String username, String password, OnLoginListener listener);
}

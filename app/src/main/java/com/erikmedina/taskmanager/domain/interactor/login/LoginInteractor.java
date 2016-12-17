package com.erikmedina.taskmanager.domain.interactor.login;

/**
 * Created by erik on 17/12/16.
 */

public interface LoginInteractor {

    interface OnLoginListener{

        void onLoginSuccess(boolean isSuccessfulLogin);

        void onLoginError(String error);
    }

    void execute(String username, String password, OnLoginListener listener);
}

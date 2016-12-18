package com.erikmedina.taskmanager.ui.login;

import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;

/**
 * Created by erik on 17/12/16.
 */
public class LoginInteractorImpl implements LoginInteractor {

    LoginPresenter loginPresenter;

    public LoginInteractorImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void checkCredentials(String username, String password, OnLoginListener listener) {
        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class)
                .equalTo("username", username)
                .equalTo("password", password)
                .findFirst();
        if (user != null) {
            listener.onLoginSuccess(user);
        } else {
            listener.onLoginError("Credentials are not valid");
        }
    }
}

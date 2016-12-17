package com.erikmedina.taskmanager.ui.login;

/**
 * Created by erik on 17/12/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    LoginView view;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
    }

    @Override
    public void checkCredentials(String username, String password) {

    }
}

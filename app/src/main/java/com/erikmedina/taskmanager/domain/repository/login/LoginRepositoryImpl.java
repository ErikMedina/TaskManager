package com.erikmedina.taskmanager.domain.repository.login;

import com.erikmedina.taskmanager.domain.interactor.login.LoginInteractor;

/**
 * Created by erik on 17/12/16.
 */
public class LoginRepositoryImpl implements LoginRepository {

    @Override
    public void validateLogin(String username, String password, LoginInteractor.OnLoginListener listener) {

    }
}

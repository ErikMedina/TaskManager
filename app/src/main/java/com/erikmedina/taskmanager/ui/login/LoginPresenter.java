package com.erikmedina.taskmanager.ui.login;

/**
 * Created by erik on 16/12/16.
 */

public interface LoginPresenter {

    void checkCredentials(String username, String password);

    void registerClicked();
}

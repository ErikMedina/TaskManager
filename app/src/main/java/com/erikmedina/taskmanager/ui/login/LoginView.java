package com.erikmedina.taskmanager.ui.login;

/**
 * Created by erik on 16/12/16.
 */

public interface LoginView {

    void goToRegistration();

    void showProgressBar();

    void dismissProgressBar();

    void showMessage(String message);

    void goToAdmin();

    void goToTechnician();

    void disableSignInButton();

    void enableSignInButton();
}

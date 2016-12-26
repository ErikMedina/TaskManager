package com.erikmedina.taskmanager.ui.admin;

/**
 * Created by erik on 18/12/16.
 */
public interface AdminView {

    void showMessage(String message);

    void goToFarmActivity();

    void showProgressBar();

    void hideProgressBar();
}

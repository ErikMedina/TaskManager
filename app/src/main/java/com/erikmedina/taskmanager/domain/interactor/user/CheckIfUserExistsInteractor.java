package com.erikmedina.taskmanager.domain.interactor.user;

/**
 * Created by erik on 23/12/16.
 */

public interface CheckIfUserExistsInteractor {

    interface OnUserExistsListener {

        void onUserExistsSuccess(boolean userExists);

        void onUserExistsError(String error);
    }

    void execute(String username, OnUserExistsListener listener);
}

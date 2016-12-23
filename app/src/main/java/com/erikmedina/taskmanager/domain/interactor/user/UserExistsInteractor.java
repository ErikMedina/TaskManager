package com.erikmedina.taskmanager.domain.interactor.user;

/**
 * Created by erik on 23/12/16.
 */

public interface UserExistsInteractor {

    interface OnUserExistsListener {

        void onUserExistsSuccess(boolean userExists);

        void onUserExistsError(String error);
    }

    void checkIfUserExists(String username, OnUserExistsListener listener);
}

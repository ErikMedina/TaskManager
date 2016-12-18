package com.erikmedina.taskmanager.domain.interactor.registration;

/**
 * Created by erik on 17/12/16.
 */

public interface RegistrationInteractor {

    interface OnRegistrationListener {

        void onRegistrationSuccess(boolean isSuccessfulRegistration);

        void onRegistrationError(String error);
    }

    void execute(String username, String password, String userType, OnRegistrationListener listener);
}

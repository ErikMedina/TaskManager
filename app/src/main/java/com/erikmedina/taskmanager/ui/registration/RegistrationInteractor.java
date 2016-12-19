package com.erikmedina.taskmanager.ui.registration;

import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 17/12/16.
 */

public interface RegistrationInteractor {

    interface OnRegistrationListener {

        void onRegistrationSuccess(boolean isSuccessfulRegistration);

        void onRegistrationError(String error);
    }

    void persistUser(User user, OnRegistrationListener listener);
}

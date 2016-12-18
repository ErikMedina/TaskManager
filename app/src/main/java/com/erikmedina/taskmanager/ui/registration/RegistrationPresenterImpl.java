package com.erikmedina.taskmanager.ui.registration;

import com.erikmedina.taskmanager.domain.interactor.registration.RegistrationInteractor;

/**
 * Created by erik on 17/12/16.
 */
public class RegistrationPresenterImpl implements RegistrationPresenter {

    RegistrationView view;
    RegistrationInteractor interactor;

    public RegistrationPresenterImpl(RegistrationView view) {
        this.view = view;
    }

    @Override
    public void registerUser(String username, String password, String userType) {
        interactor.execute(username, password, userType, new RegistrationInteractor.OnRegistrationListener() {
            @Override
            public void onRegistrationSuccess(boolean isSuccessfulRegistration) {

            }

            @Override
            public void onRegistrationError(String error) {

            }
        });
    }
}

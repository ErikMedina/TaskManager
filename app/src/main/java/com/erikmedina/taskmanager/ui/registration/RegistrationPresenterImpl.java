package com.erikmedina.taskmanager.ui.registration;

import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 17/12/16.
 */
public class RegistrationPresenterImpl implements RegistrationPresenter {

    private RegistrationView view;
    private RegistrationInteractor interactor;

    public RegistrationPresenterImpl(RegistrationView view) {
        this.view = view;
        this.interactor =new RegistrationInteractorImpl();
    }

    @Override
    public void registerUser(String username, String password, String userType) {
        User user = new User(username, password, userType);
        interactor.persistUser(user, new RegistrationInteractor.OnRegistrationListener() {
            @Override
            public void onRegistrationSuccess(boolean isSuccessfulRegistration) {

            }

            @Override
            public void onRegistrationError(String error) {

            }
        });
    }
}

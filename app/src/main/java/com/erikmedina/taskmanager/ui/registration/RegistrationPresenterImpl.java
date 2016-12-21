package com.erikmedina.taskmanager.ui.registration;

import com.erikmedina.taskmanager.domain.interactor.user.RegisterUserInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.RegisterUserInteractorImpl;
import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 17/12/16.
 */
public class RegistrationPresenterImpl implements RegistrationPresenter {

    private RegistrationView view;
    private RegisterUserInteractor registerUserInteractor;

    public RegistrationPresenterImpl(RegistrationView view) {
        this.view = view;
        this.registerUserInteractor = new RegisterUserInteractorImpl();
    }

    @Override
    public void registerUser(String username, String password, String userType) {
        User user = new User(username, password, userType);
        registerUserInteractor.persistUser(user, new RegisterUserInteractor.OnRegisterUserListener() {
            @Override
            public void onRegisterUserSuccess(boolean isSuccessfulRegistration) {
                if (view != null) {
                    view.showMessage("User has been register");
                    view.finishActivity();
                }
            }

            @Override
            public void onRegisterUserError(String error) {

            }
        });
    }
}

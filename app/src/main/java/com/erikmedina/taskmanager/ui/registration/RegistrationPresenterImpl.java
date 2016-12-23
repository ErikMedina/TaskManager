package com.erikmedina.taskmanager.ui.registration;

import com.erikmedina.taskmanager.domain.interactor.user.RegisterUserInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.RegisterUserInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.user.UserExistsInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.UserExistsInteractorImpl;
import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 17/12/16.
 */
public class RegistrationPresenterImpl implements RegistrationPresenter {

    private RegistrationView view;
    private UserExistsInteractor userExistsInteractor;
    private RegisterUserInteractor registerUserInteractor;

    public RegistrationPresenterImpl(RegistrationView view) {
        this.view = view;
        this.registerUserInteractor = new RegisterUserInteractorImpl();
        this.userExistsInteractor = new UserExistsInteractorImpl();
    }

    @Override
    public void registerUser(final String username, final String password, final String userType) {
        userExistsInteractor.checkIfUserExists(username, new UserExistsInteractor.OnUserExistsListener() {
            @Override
            public void onUserExistsSuccess(boolean userExists) {
                if (!userExists) {
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
                } else {
                    view.showMessage("User already exists");
                }
            }

            @Override
            public void onUserExistsError(String error) {

            }
        });

    }
}

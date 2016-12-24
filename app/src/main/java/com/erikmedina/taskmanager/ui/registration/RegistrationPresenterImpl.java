package com.erikmedina.taskmanager.ui.registration;

import com.erikmedina.taskmanager.domain.interactor.user.CheckIfUserExistsInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.CheckIfUserExistsInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.user.RegisterUserInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.RegisterUserInteractorImpl;
import com.erikmedina.taskmanager.model.User;

import java.util.List;

/**
 * Created by erik on 17/12/16.
 */
public class RegistrationPresenterImpl implements RegistrationPresenter {

    private RegistrationView view;
    private CheckIfUserExistsInteractor checkIfUserExistsInteractor;
    private RegisterUserInteractor registerUserInteractor;

    public RegistrationPresenterImpl(RegistrationView view) {
        this.view = view;
        this.registerUserInteractor = new RegisterUserInteractorImpl();
        this.checkIfUserExistsInteractor = new CheckIfUserExistsInteractorImpl();
    }

    @Override
    public void registerUser(final String username, final String password, final String userType,
                             final List skillsSelected) {
        checkIfUserExistsInteractor.execute(username, new CheckIfUserExistsInteractor.OnUserExistsListener() {
            @Override
            public void onUserExistsSuccess(boolean userExists) {
                if (!userExists) {
                    User user = new User(username, password, userType, skillsSelected);
                    registerUserInteractor.execute(user, new RegisterUserInteractor.OnRegisterUserListener() {
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
                    if (view != null) {
                        view.showMessage("User already exists");
                    }
                }
            }

            @Override
            public void onUserExistsError(String error) {

            }
        });

    }

    @Override
    public void selectSkillsButtonClicked() {
        if (view != null) {
            view.showSkillsSelectionDialog();
        }
    }
}

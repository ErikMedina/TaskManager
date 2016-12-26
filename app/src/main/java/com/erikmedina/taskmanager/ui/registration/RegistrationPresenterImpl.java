package com.erikmedina.taskmanager.ui.registration;

import com.erikmedina.taskmanager.domain.interactor.user.CheckIfUserExistsInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.CheckIfUserExistsInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.user.RegisterUserInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.RegisterUserInteractorImpl;
import com.erikmedina.taskmanager.model.User;
import com.erikmedina.taskmanager.util.Utils;

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
        if (view != null) {
            view.showProgressBar();
        }
        if (areFilledFields(username, password)) {
            if (userType.matches(Utils.ADMIN) || (skillsSelected != null && skillsSelected.size() > 0)) {
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
                                    if (view != null) {
                                        view.hideProgressBar();
                                    }
                                }
                            });
                        } else {
                            if (view != null) {
                                view.hideProgressBar();
                                view.showMessage("User already exists");
                            }
                        }
                    }

                    @Override
                    public void onUserExistsError(String error) {

                    }
                });
            } else {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage("Choose at least one skill");
                }
            }
        } else {
            if (view != null) {
                view.hideProgressBar();
                view.showMessage("Fill empty fields");
            }
        }
    }

    private boolean areFilledFields(String username, String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void selectSkillsButtonClicked() {
        if (view != null) {
            view.showSkillsSelectionDialog();
        }
    }
}

package com.erikmedina.taskmanager.ui.login;

import com.erikmedina.taskmanager.domain.interactor.user.CheckLoginInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.CheckLoginInteractorImpl;
import com.erikmedina.taskmanager.model.User;
import com.erikmedina.taskmanager.util.Utils;

/**
 * Created by erik on 17/12/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;
    private CheckLoginInteractor checkLoginInteractor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        checkLoginInteractor = new CheckLoginInteractorImpl();
    }

    @Override
    public void signInButtonClicked(String username, String password) {
        if (view != null) {
            view.showProgressBar();
            view.disableSignInButton();
        }
        if (areFilledFields(username, password)) {
            checkLoginInteractor.execute(username, password, new CheckLoginInteractor.OnLoginListener() {
                @Override
                public void onLoginSuccess(User user) {
                    if (view != null) {
                        view.dismissProgressBar();
                        view.enableSignInButton();
                        switch (user.getUserType()) {
                            case Utils.ADMIN:
                                view.goToAdmin();
                                break;
                            case Utils.TECHNICIAN:
                                view.goToTechnician(user);
                                break;
                        }
                    }
                }

                @Override
                public void onLoginError(String error) {
                    if (view != null) {
                        view.dismissProgressBar();
                        view.enableSignInButton();
                        view.showMessage(error);
                    }
                }
            });
        } else {
            if (view != null) {
                view.dismissProgressBar();
                view.enableSignInButton();
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
    public void registerClicked() {
        view.goToRegistration();
    }
}

package com.erikmedina.taskmanager.ui.login;

import com.erikmedina.taskmanager.domain.interactor.user.LoginInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.LoginInteractorImpl;
import com.erikmedina.taskmanager.model.User;
import com.erikmedina.taskmanager.util.Utils;

/**
 * Created by erik on 17/12/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void signInButtonClicked(String username, String password) {
        if (view != null) {
            view.showProgressBar();
            view.disableSignInButton();
        }
        loginInteractor.checkCredentials(username, password, new LoginInteractor.OnLoginListener() {
            @Override
            public void onLoginSuccess(User user) {
                if (view != null) {
                    view.dismissProgressBar();
                    view.enableSignInButton();
                    switch (user.getUserType()){
                        case Utils.ADMIN:
                            view.goToAdmin();
                            break;
                        case Utils.TECHNICIAN:
                            view.goToTechnician();
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
    }

    @Override
    public void registerClicked() {
        view.goToRegistration();
    }
}

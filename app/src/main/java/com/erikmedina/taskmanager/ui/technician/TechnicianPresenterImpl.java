package com.erikmedina.taskmanager.ui.technician;

import com.erikmedina.taskmanager.domain.interactor.user.GetUserByIdInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.GetUserByIdInteractorImpl;
import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 21/12/16.
 */
public class TechnicianPresenterImpl implements TechnicianPresenter {

    private TechnicianView view;
    private GetUserByIdInteractor getUserByIdInteractor;

    public TechnicianPresenterImpl(TechnicianView view) {
        this.view = view;
        getUserByIdInteractor = new GetUserByIdInteractorImpl();
    }

    @Override
    public void webServiceButtonClicked() {
        view.goToFarmActivity();
    }

    @Override
    public void initializeUser(int userId) {
        getUserByIdInteractor.execute(userId, new GetUserByIdInteractor.OnGetUserByIdListener() {
            @Override
            public void onGetUserByIdSuccess(User user) {
                if (view != null) {
                    view.setTasksList(user.getTasks());
                }
            }

            @Override
            public void onGetUserByIdError(String error) {

            }
        });
    }
}

package com.erikmedina.taskmanager.ui.admin;

import com.erikmedina.taskmanager.model.Task;

import timber.log.Timber;

/**
 * Created by erik on 18/12/16.
 */
public class AdminPresenterImpl implements AdminPresenter {

    private AdminView view;
    private AdminInteractor interactor;

    public AdminPresenterImpl(AdminView view) {
        this.view = view;
        interactor = new AdminInteractorImpl();
    }

    @Override
    public void createButtonClicked(String description, String duration, String type) {
        if (areFilledFields(description, duration, type)) {
            Task task = new Task(description, Integer.parseInt(duration), Integer.parseInt(type));
            interactor.createTask(task, new AdminInteractor.OnAdminListener() {
                @Override
                public void onAdminSuccess() {
                    Timber.i("Se ha creado la tarea");
                }

                @Override
                public void onAdminError(String error) {

                }
            });
        } else {
            if (view != null) {
                view.showMessage("Fill empty fields");
            }
        }
    }

    private boolean areFilledFields(String description, String duration, String type) {
        if (description.isEmpty() || duration.isEmpty() || type.isEmpty()) {
            return false;
        } else return true;
    }
}

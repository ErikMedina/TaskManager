package com.erikmedina.taskmanager.ui.admin;

import com.erikmedina.taskmanager.domain.interactor.task.CreateTaskInteractor;
import com.erikmedina.taskmanager.domain.interactor.task.CreateTaskInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.task.CheckIfTaskExistsInteractor;
import com.erikmedina.taskmanager.domain.interactor.task.CheckIfTaskExistsInteractorImpl;
import com.erikmedina.taskmanager.model.Task;

/**
 * Created by erik on 18/12/16.
 */
public class AdminPresenterImpl implements AdminPresenter {

    private AdminView view;
    private CreateTaskInteractor createTaskInteractor;
    private CheckIfTaskExistsInteractor checkIfTaskExistsInteractor;

    public AdminPresenterImpl(AdminView view) {
        this.view = view;
        createTaskInteractor = new CreateTaskInteractorImpl();
        checkIfTaskExistsInteractor = new CheckIfTaskExistsInteractorImpl();
    }

    @Override
    public void createButtonClicked(final String description, final String duration, final String type) {
        if (areFilledFields(description, duration, type)) {
            checkIfTaskExistsInteractor.execute(type, new CheckIfTaskExistsInteractor.OnTaskExistsListener() {
                @Override
                public void onTaskExistsSuccess(boolean taskExists) {
                    if (!taskExists) {
                        Task task = new Task(description, Integer.parseInt(duration), Integer.parseInt(type));
                        createTaskInteractor.execute(task, new CreateTaskInteractor.OnCreateTaskListener() {
                            @Override
                            public void onCreateTaskSuccess() {
                                if (view != null) {
                                    view.showMessage("Task has been created");
                                }
                            }

                            @Override
                            public void onCreateTaskError(String error) {

                            }
                        });
                    } else {
                        if (view != null) {
                            view.showMessage("Task already exists");
                        }
                    }
                }

                @Override
                public void onTaskExistsError(String error) {

                }
            });

        } else {
            if (view != null) {
                view.showMessage("Fill empty fields");
            }
        }
    }

    @Override
    public void webServiceButtonClicked() {
        view.goToFarmActivity();
    }

    private boolean areFilledFields(String description, String duration, String type) {
        if (description.isEmpty() || duration.isEmpty() || type.isEmpty()) {
            return false;
        } else return true;
    }
}

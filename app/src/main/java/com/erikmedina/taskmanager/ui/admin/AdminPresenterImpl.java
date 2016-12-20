package com.erikmedina.taskmanager.ui.admin;

import com.erikmedina.taskmanager.domain.entity.Farmer;
import com.erikmedina.taskmanager.domain.interactor.farm.GetFarmersInteractor;
import com.erikmedina.taskmanager.domain.interactor.farm.GetFarmersInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.task.CreateTaskInteractor;
import com.erikmedina.taskmanager.domain.interactor.task.CreateTaskInteractorImpl;
import com.erikmedina.taskmanager.model.Task;

import java.util.List;

import timber.log.Timber;

/**
 * Created by erik on 18/12/16.
 */
public class AdminPresenterImpl implements AdminPresenter {

    private AdminView view;
    private GetFarmersInteractor getFarmersInteractor;
    private CreateTaskInteractor createTaskInteractor;

    public AdminPresenterImpl(AdminView view) {
        this.view = view;
        getFarmersInteractor = new GetFarmersInteractorImpl();
        createTaskInteractor = new CreateTaskInteractorImpl();
    }

    @Override
    public void createButtonClicked(String description, String duration, String type) {
        if (areFilledFields(description, duration, type)) {
            Task task = new Task(description, Integer.parseInt(duration), Integer.parseInt(type));
            createTaskInteractor.execute(task, new CreateTaskInteractor.OnCreateTaskListener() {
                @Override
                public void onCreateTaskSuccess() {
                }

                @Override
                public void onCreateTaskError(String error) {

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
       getFarmersInteractor.execute("Fruit", "Peaches", new GetFarmersInteractor.OnGetFarmersListener() {
           @Override
           public void onGetFarmersSuccess(List<Farmer> farmers) {
               Timber.i("He recuperado los farmers");
           }

           @Override
           public void onGetFarmersError(String error) {

           }
       });
    }

    private boolean areFilledFields(String description, String duration, String type) {
        if (description.isEmpty() || duration.isEmpty() || type.isEmpty()) {
            return false;
        } else return true;
    }
}

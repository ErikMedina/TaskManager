package com.erikmedina.taskmanager.ui.admin;

import com.erikmedina.taskmanager.domain.interactor.user.AddTaskToUserInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.AddTaskToUserInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.user.GetUsersBySkillInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.GetUsersBySkillInteractorImpl;
import com.erikmedina.taskmanager.domain.interactor.user.UpdateUserWorkLoadInteractor;
import com.erikmedina.taskmanager.domain.interactor.user.UpdateUserWorkLoadInteractorImpl;
import com.erikmedina.taskmanager.model.Task;
import com.erikmedina.taskmanager.model.User;

import java.util.List;

/**
 * Created by erik on 18/12/16.
 */
public class AdminPresenterImpl implements AdminPresenter {

    private AdminView view;
    private GetUsersBySkillInteractor getUsersBySkillInteractor;
    private AddTaskToUserInteractor addTaskToUserInteractor;
    private UpdateUserWorkLoadInteractor updateUserWorkLoadInteractor;

    public AdminPresenterImpl(AdminView view) {
        this.view = view;
        getUsersBySkillInteractor = new GetUsersBySkillInteractorImpl();
        addTaskToUserInteractor = new AddTaskToUserInteractorImpl();
        updateUserWorkLoadInteractor = new UpdateUserWorkLoadInteractorImpl();
    }

    @Override
    public void createButtonClicked(final String description, final String duration, final int type) {
        if (areFilledFields(description, duration)) {
            final Task task = new Task(description, Integer.parseInt(duration), type);
            getUsersBySkillInteractor.execute(type, new GetUsersBySkillInteractor.OnGetUsersBySkillListener() {
                @Override
                public void onGetUsersBySkillSuccess(List<User> users) {
                    final User user = getUserWithLessWorkLoad(users);
                    addTaskToUserInteractor.execute(user, task, new AddTaskToUserInteractor.OnAddTaskToUserListener() {
                        @Override
                        public void onAddTaskToUserSuccess() {
                            updateUserWorkLoadInteractor.execute(user, task.getDuration(), true,
                                    new UpdateUserWorkLoadInteractor.OnUpdateUserWorkLoadListener() {
                                        @Override
                                        public void onUpdateUserWorkLoadSuccess() {
                                            if (view != null) {
                                                view.showMessage("Task has been created and assigned to a technician");
                                            }
                                        }

                                        @Override
                                        public void onUpdateUserWorkLoadError(String error) {

                                        }
                                    });
                        }

                        @Override
                        public void onAddTaskToUserError(String error) {

                        }
                    });
                }

                @Override
                public void onGetUsersBySkillError(String message) {
                    if (view != null) {
                        view.showMessage(message);
                    }
                }
            });
        } else {
            if (view != null) {
                view.showMessage("Fill empty fields");
            }
        }
    }

    private boolean areFilledFields(String description, String duration) {
        if (description.isEmpty() || duration.isEmpty()) {
            return false;
        } else return true;
    }

    private User getUserWithLessWorkLoad(List<User> users) {
        int minWorkLoad = users.get(0).getWorkLoad();
        int userPosition = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getWorkLoad() < minWorkLoad) {
                minWorkLoad = users.get(i).getWorkLoad();
                userPosition = i;
            }
        }
        return users.get(userPosition);
    }

    @Override
    public void webServiceButtonClicked() {
        view.goToFarmActivity();
    }
}

package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.Task;
import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 26/12/16.
 */

public interface AddTaskToUserInteractor {

    interface OnAddTaskToUserListener {

        void onAddTaskToUserSuccess();

        void onAddTaskToUserError(String error);
    }

    void execute(User user, Task task, OnAddTaskToUserListener listener);
}

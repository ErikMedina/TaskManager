package com.erikmedina.taskmanager.domain.interactor.task;

import com.erikmedina.taskmanager.model.Task;

/**
 * Created by erik on 20/12/16.
 */

public interface CreateTaskInteractor {

    interface OnCreateTaskListener {

        void onCreateTaskSuccess();

        void onCreateTaskError(String error);
    }

    void execute(Task task, OnCreateTaskListener listener);
}

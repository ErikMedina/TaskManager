package com.erikmedina.taskmanager.domain.interactor.task;

import com.erikmedina.taskmanager.model.Task;

/**
 * Created by erik on 26/12/16.
 */

public interface CompleteTaskInteractor {

    interface OnCompleteTaskListener{

        void onCompleteTaskSuccess();

        void onCompleteTaskError();
    }

    void execute(Task task, OnCompleteTaskListener listener);
}

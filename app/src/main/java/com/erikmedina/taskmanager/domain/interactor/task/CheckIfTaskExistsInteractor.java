package com.erikmedina.taskmanager.domain.interactor.task;

/**
 * Created by erik on 23/12/16.
 */

public interface CheckIfTaskExistsInteractor {

    interface OnTaskExistsListener {

        void onTaskExistsSuccess(boolean taskExists);

    void onTaskExistsError(String error);
}

    void execute(String type, CheckIfTaskExistsInteractor.OnTaskExistsListener listener);
}

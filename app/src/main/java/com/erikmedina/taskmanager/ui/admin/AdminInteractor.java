package com.erikmedina.taskmanager.ui.admin;

import com.erikmedina.taskmanager.model.Task;

/**
 * Created by erik on 18/12/16.
 */

public interface AdminInteractor {

    interface OnAdminListener{

        void onAdminSuccess();

        void onAdminError(String error);
    }

    void createTask(Task task, OnAdminListener listener);
}

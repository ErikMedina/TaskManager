package com.erikmedina.taskmanager.ui.admin;

import com.erikmedina.taskmanager.domain.entity.Farmer;
import com.erikmedina.taskmanager.model.Task;

import java.util.List;

/**
 * Created by erik on 18/12/16.
 */

public interface AdminInteractor {

    interface OnAdminListener{

        void onAdminSuccess(List<Farmer> farmers);

        void onAdminError(String error);

    }

    interface OnCreateTaskListener{

        void onCreateTaskSuccess();

        void onCreateTaskError(String error);
    }

    void createTask(Task task, OnCreateTaskListener listener);

    void makeWebPetition(String fruit, String peaches, OnAdminListener listener);
}

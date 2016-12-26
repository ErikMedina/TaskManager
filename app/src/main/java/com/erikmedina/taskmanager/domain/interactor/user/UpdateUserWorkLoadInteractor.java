package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 26/12/16.
 */

public interface UpdateUserWorkLoadInteractor {

    interface OnUpdateUserWorkLoadListener {

        void onUpdateUserWorkLoadSuccess();

        void onUpdateUserWorkLoadError(String error);
    }

    void execute(User user, int taskDuration, boolean isSum, OnUpdateUserWorkLoadListener listener);
}

package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

/**
 * Created by erik on 26/12/16.
 */

public interface GetUserByIdInteractor {

    interface OnGetUserByIdListener{

        void onGetUserByIdSuccess(User user);

        void onGetUserByIdError(String error);
    }

    void execute(int id, OnGetUserByIdListener listener);
}

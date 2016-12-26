package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

import java.util.List;

/**
 * Created by erik on 24/12/16.
 */

public interface GetUsersBySkillInteractor {

    interface OnGetUsersBySkillListener {

        void onGetUsersBySkillSuccess(List<User> users);

        void onGetUsersBySkillError(String message);
    }

    void execute(int type, OnGetUsersBySkillListener listener);
}

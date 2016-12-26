package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

import java.util.List;

/**
 * Created by erik on 24/12/16.
 */

public interface GetUsersBySkillInteractor {

    interface OnGetUsersBySkillListener {

        void OnGetUsersBySkillSuccess(List<User> users);

        void OnGetUsersBySkillError(String message);
    }

    void execute(int type, OnGetUsersBySkillListener listener);
}

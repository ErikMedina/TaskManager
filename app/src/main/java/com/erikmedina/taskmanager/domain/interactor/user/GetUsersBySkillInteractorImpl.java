package com.erikmedina.taskmanager.domain.interactor.user;

import com.erikmedina.taskmanager.model.User;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by erik on 24/12/16.
 */
public class GetUsersBySkillInteractorImpl implements GetUsersBySkillInteractor {

    @Override
    public void execute(int type, OnGetUsersBySkillListener listener) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> results = realm.where(User.class)
                .equalTo("taskTypes.value", type)
                .findAll();
        if (results.size() > 0) {
            listener.onGetUsersBySkillSuccess(results);
        } else {
            listener.onGetUsersBySkillError("There are not technicians with that skill");
        }
    }
}

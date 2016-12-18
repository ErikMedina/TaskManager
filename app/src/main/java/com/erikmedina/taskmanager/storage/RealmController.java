package com.erikmedina.taskmanager.storage;

import android.content.Context;

import io.realm.Realm;

/**
 * Created by erik on 17/12/16.
 */

public class RealmController<T> {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Context context) {
        realm = Realm.getDefaultInstance();
    }


}

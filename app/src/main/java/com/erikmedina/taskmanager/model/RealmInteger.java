package com.erikmedina.taskmanager.model;

import io.realm.RealmObject;

/**
 * Created by erik on 24/12/16.
 */

public class RealmInteger extends RealmObject {

    private Integer value;

    public RealmInteger() {
    }

    public RealmInteger(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

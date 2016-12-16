package com.erikmedina.taskmanager;

import android.app.Application;

import com.erikmedina.taskmanager.util.CrashReportingTree;

import timber.log.Timber;

/**
 * Created by erik on 16/12/16.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }
}

package com.erikmedina.taskmanager;

import com.erikmedina.taskmanager.util.logging.CrashReportingTree;
import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Created by erik on 16/12/16.
 */

public class MyApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }
}

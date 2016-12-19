package com.erikmedina.taskmanager.util.logging;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by erik on 16/12/16.
 */

public class CrashReportingTree extends Timber.Tree {

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }
    }
}

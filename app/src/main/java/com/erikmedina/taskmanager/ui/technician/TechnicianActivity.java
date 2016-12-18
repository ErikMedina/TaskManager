package com.erikmedina.taskmanager.ui.technician;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;

/**
 * Created by erik on 18/12/16.
 */

public class TechnicianActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.name_technician);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_technician;
    }
}

package com.erikmedina.taskmanager.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;

/**
 * Created by erik on 16/12/16.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.login_name);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login;
    }
}

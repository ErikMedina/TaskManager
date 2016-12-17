package com.erikmedina.taskmanager.ui.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;

/**
 * Created by erik on 17/12/16.
 */

public class RegistrationActivity extends BaseActivity implements RegistrationView {

    RegistrationPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new RegistrationPresenterImpl(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_registration;
    }
}

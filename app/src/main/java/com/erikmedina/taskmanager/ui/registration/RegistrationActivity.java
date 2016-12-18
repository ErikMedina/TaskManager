package com.erikmedina.taskmanager.ui.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.widget.Spinner;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by erik on 17/12/16.
 */

public class RegistrationActivity extends BaseActivity implements RegistrationView {

    @BindView(R.id.tiet_username_registration)
    TextInputEditText tietUsernameRegistration;
    @BindView(R.id.tiet_password_registration)
    TextInputEditText tietPasswordRegistration;
    @BindView(R.id.s_user_type_registration)
    Spinner sUserTypeRegistration;

    RegistrationPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.registration_name);

        presenter = new RegistrationPresenterImpl(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_registration;
    }

    @OnClick(R.id.b_sign_in_registration)
    public void onRegisterButtonClicked(){
        presenter.registerUser(tietUsernameRegistration.getText().toString(),
                tietPasswordRegistration.getText().toString(),
                sUserTypeRegistration.getSelectedItem().toString());
    }
}

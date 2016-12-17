package com.erikmedina.taskmanager.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.TextView;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;
import com.erikmedina.taskmanager.ui.registration.RegistrationActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by erik on 16/12/16.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    LoginPresenter presenter;
    @BindView(R.id.tiet_username_login)
    TextInputEditText tietUsernameLogin;
    @BindView(R.id.tiet_password_login)
    TextInputEditText tietPasswordLogin;
    @BindView(R.id.b_sign_in_login)
    Button bSignInLogin;
    @BindView(R.id.tv_register_login)
    TextView tvRegisterLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.login_name);
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.b_sign_in_login)
    public void onSignInButtonClicked() {
        presenter.checkCredentials(tietUsernameLogin.getText().toString(),
                tietPasswordLogin.getText().toString());
    }

    @OnClick(R.id.tv_register_login)
    public void onRegisterClicked(){
        presenter.registerClicked();
    }

    @Override
    public void goToRegistration() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}

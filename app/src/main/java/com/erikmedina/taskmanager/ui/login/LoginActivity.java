package com.erikmedina.taskmanager.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;

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
}

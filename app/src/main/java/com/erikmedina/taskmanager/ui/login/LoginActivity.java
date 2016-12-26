package com.erikmedina.taskmanager.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.model.User;
import com.erikmedina.taskmanager.ui.admin.AdminActivity;
import com.erikmedina.taskmanager.ui.base.BaseActivity;
import com.erikmedina.taskmanager.ui.registration.RegistrationActivity;
import com.erikmedina.taskmanager.ui.technician.TechnicianActivity;

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
    @BindView(R.id.pb_login)
    ProgressBar pbLogin;

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
        presenter.signInButtonClicked(tietUsernameLogin.getText().toString(),
                tietPasswordLogin.getText().toString());
    }

    @OnClick(R.id.tv_register_login)
    public void onRegisterClicked() {
        presenter.registerClicked();
    }

    @Override
    public void goToRegistration() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgressBar() {
        pbLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgressBar() {
        pbLogin.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToAdmin() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void goToTechnician(User user) {
        Intent intent = new Intent(this, TechnicianActivity.class);
        intent.putExtra("id", user.getId());
        startActivity(intent);
        finish();
    }

    @Override
    public void disableSignInButton() {
        bSignInLogin.setEnabled(false);
    }

    @Override
    public void enableSignInButton() {
        bSignInLogin.setEnabled(true);
    }
}

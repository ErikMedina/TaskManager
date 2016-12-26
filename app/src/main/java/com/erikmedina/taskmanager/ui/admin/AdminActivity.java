package com.erikmedina.taskmanager.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;
import com.erikmedina.taskmanager.ui.farm.FarmActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by erik on 18/12/16.
 */

public class AdminActivity extends BaseActivity implements AdminView {

    AdminPresenter presenter;
    @BindView(R.id.tiet_task_description)
    TextInputEditText tietTaskDescription;
    @BindView(R.id.tiet_task_duration)
    TextInputEditText tietTaskDuration;
    @BindView(R.id.s_task_type)
    Spinner sTaskType;
    @BindView(R.id.b_create_task)
    Button bCreateTask;
    @BindView(R.id.pb_admin)
    ProgressBar pbAdmin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.admin_name);

        presenter = new AdminPresenterImpl(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_admin;
    }

    @OnClick(R.id.b_create_task)
    public void onCreateButtonClicked() {
        presenter.createButtonClicked(tietTaskDescription.getText().toString(),
                tietTaskDuration.getText().toString(),
                sTaskType.getSelectedItemPosition());
    }

    @OnClick(R.id.b_web_service_admin)
    public void onWebServiceButtonClicked() {
        presenter.webServiceButtonClicked();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToFarmActivity() {
        Intent intent = new Intent(this, FarmActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgressBar() {
        pbAdmin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbAdmin.setVisibility(View.GONE);
    }
}

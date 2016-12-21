package com.erikmedina.taskmanager.ui.technician;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.ui.base.BaseActivity;
import com.erikmedina.taskmanager.ui.farm.FarmActivity;

import butterknife.OnClick;

/**
 * Created by erik on 18/12/16.
 */

public class TechnicianActivity extends BaseActivity implements TechnicianView {

    TechnicianPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.name_technician);

        presenter = new TechnicianPresenterImpl(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_technician;
    }

    @OnClick(R.id.b_web_service_technician)
    public void onWebServiceButtonClicked() {
        presenter.webServiceButtonClicked();
    }

    @Override
    public void goToFarmActivity() {
        Intent intent = new Intent(this, FarmActivity.class);
        startActivity(intent);
    }
}

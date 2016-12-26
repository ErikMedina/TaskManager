package com.erikmedina.taskmanager.ui.technician;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.model.Task;
import com.erikmedina.taskmanager.ui.base.BaseActivity;
import com.erikmedina.taskmanager.ui.farm.FarmActivity;
import com.erikmedina.taskmanager.ui.technician.adapter.TaskAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.RealmList;

/**
 * Created by erik on 18/12/16.
 */

public class TechnicianActivity extends BaseActivity implements TechnicianView {

    @BindView(R.id.rv_tasks_technician)
    RecyclerView rvTasksTechnician;


    TechnicianPresenter presenter;
    TaskAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.name_technician);
        presenter = new TechnicianPresenterImpl(this);

        Intent intent = getIntent();
        int userId = intent.getIntExtra("id", 0);

        adapter = new TaskAdapter(this, userId, new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Task task) {
            }
        });
        rvTasksTechnician.setAdapter(adapter);
        rvTasksTechnician.setLayoutManager(new LinearLayoutManager(this));
        presenter.initializeUser(userId);

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

    @Override
    public void setTasksList(RealmList<Task> tasks) {
        adapter.setTasks(tasks);
    }
}

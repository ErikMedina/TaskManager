package com.erikmedina.taskmanager.ui.farm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.domain.entity.Farm;
import com.erikmedina.taskmanager.ui.base.BaseActivity;
import com.erikmedina.taskmanager.ui.farm.adapter.FarmsAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by erik on 20/12/16.
 */

public class FarmActivity extends BaseActivity implements FarmView {

    @BindView(R.id.rv_farms)
    RecyclerView rvFarms;

    FarmsAdapter adapter;
    FarmPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.farms_name);

        presenter = new FarmPresenterImpl(this);
        presenter.getFarms();

        adapter = new FarmsAdapter(this);
        rvFarms.setAdapter(adapter);
        rvFarms.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_web_service;
    }

    @Override
    public void setFarms(List<Farm> farms) {
        adapter.setFarms(farms);
    }
}

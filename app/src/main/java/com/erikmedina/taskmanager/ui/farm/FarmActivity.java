package com.erikmedina.taskmanager.ui.farm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.domain.entity.Farm;
import com.erikmedina.taskmanager.ui.base.BaseActivity;
import com.erikmedina.taskmanager.ui.farm.adapter.FarmAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by erik on 20/12/16.
 */

public class FarmActivity extends BaseActivity implements FarmView {

    @BindView(R.id.rv_farms)
    RecyclerView rvFarms;

    FarmAdapter adapter;
    FarmPresenter presenter;
    @BindView(R.id.pb_admin)
    ProgressBar pbAdmin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.farms_name);

        presenter = new FarmPresenterImpl(this);
        presenter.getFarms();

        adapter = new FarmAdapter(this);
        rvFarms.setAdapter(adapter);
        rvFarms.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_farm;
    }

    @Override
    public void setFarms(List<Farm> farms) {
        adapter.setFarms(farms);
    }

    @Override
    public void showProgressBar() {
        pbAdmin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideShowProgressBar() {
        pbAdmin.setVisibility(View.GONE);
    }
}

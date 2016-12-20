package com.erikmedina.taskmanager.domain.interactor.farm;

import com.erikmedina.taskmanager.domain.entity.Farmer;

import java.util.List;

/**
 * Created by erik on 20/12/16.
 */

public interface GetFarmersInteractor {

    interface OnGetFarmersListener {

        void onGetFarmersSuccess(List<Farmer> farmers);

        void onGetFarmersError(String error);
    }

    void execute(String category, String item, OnGetFarmersListener listener);
}

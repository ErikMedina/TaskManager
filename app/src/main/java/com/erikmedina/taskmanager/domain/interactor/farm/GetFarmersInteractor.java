package com.erikmedina.taskmanager.domain.interactor.farm;

import com.erikmedina.taskmanager.domain.entity.Farm;

import java.util.List;

/**
 * Created by erik on 20/12/16.
 */

public interface GetFarmersInteractor {

    interface OnGetFarmersListener {

        void onGetFarmersSuccess(List<Farm> farmers);

        void onGetFarmersError(String error);
    }

    void execute(String category, String item, OnGetFarmersListener listener);
}

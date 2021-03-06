package com.erikmedina.taskmanager.ui.farm;

import com.erikmedina.taskmanager.domain.entity.Farm;
import com.erikmedina.taskmanager.domain.interactor.farm.GetFarmersInteractor;
import com.erikmedina.taskmanager.domain.interactor.farm.GetFarmersInteractorImpl;

import java.util.List;

/**
 * Created by erik on 20/12/16.
 */
public class FarmPresenterImpl implements FarmPresenter {

    private FarmView view;
    private GetFarmersInteractor getFarmersInteractor;

    public FarmPresenterImpl(FarmView view) {
        this.view = view;
        getFarmersInteractor = new GetFarmersInteractorImpl();
    }

    @Override
    public void getFarms() {
        if (view != null) {
            view.showProgressBar();
        }
        getFarmersInteractor.execute("Fruit", "Peaches", new GetFarmersInteractor.OnGetFarmersListener() {
            @Override
            public void onGetFarmersSuccess(List<Farm> farmers) {
                if (view != null) {
                    view.hideShowProgressBar();
                    view.setFarms(farmers);
                }
            }

            @Override
            public void onGetFarmersError(String error) {
                if (view != null) {
                    view.hideShowProgressBar();
                }
            }
        });
    }
}

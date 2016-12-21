package com.erikmedina.taskmanager.ui.technician;

/**
 * Created by erik on 21/12/16.
 */
public class TechnicianPresenterImpl implements TechnicianPresenter {

    private TechnicianView view;

    public TechnicianPresenterImpl(TechnicianView view) {
        this.view = view;
    }

    @Override
    public void webServiceButtonClicked() {
        view.goToFarmActivity();
    }
}

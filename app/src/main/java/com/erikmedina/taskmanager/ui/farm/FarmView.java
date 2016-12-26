package com.erikmedina.taskmanager.ui.farm;

import com.erikmedina.taskmanager.domain.entity.Farm;

import java.util.List;

/**
 * Created by erik on 20/12/16.
 */

public interface FarmView {

    void setFarms(List<Farm> farms);

    void showProgressBar();

    void hideShowProgressBar();
}

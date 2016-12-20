package com.erikmedina.taskmanager.domain.interactor.farm;

import com.erikmedina.taskmanager.domain.entity.Farmer;
import com.erikmedina.taskmanager.domain.service.ServiceManager;
import com.erikmedina.taskmanager.domain.service.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by erik on 20/12/16.
 */
public class GetFarmersInteractorImpl implements GetFarmersInteractor {

    private WebService webService;

    public GetFarmersInteractorImpl() {
        webService = ServiceManager.createWebService();
    }

    @Override
    public void execute(String category, String item, final OnGetFarmersListener listener) {
        Call<List<Farmer>> call =webService.getWebService(category,item);
        call.enqueue(new Callback<List<Farmer>>() {
            @Override
            public void onResponse(Call<List<Farmer>> call, Response<List<Farmer>> response) {
                if(response.isSuccessful()){
                    listener.onGetFarmersSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Farmer>> call, Throwable t) {

            }
        });
    }
}

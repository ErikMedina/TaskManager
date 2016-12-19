package com.erikmedina.taskmanager.ui.admin;

import com.erikmedina.taskmanager.domain.entity.Farmer;
import com.erikmedina.taskmanager.domain.service.ServiceManager;
import com.erikmedina.taskmanager.domain.service.WebService;
import com.erikmedina.taskmanager.model.Task;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by erik on 19/12/16.
 */
public class AdminInteractorImpl implements AdminInteractor {

    private WebService webService;

    public AdminInteractorImpl() {
        webService = ServiceManager.createWebService();
    }

    @Override
    public void createTask(Task task, OnCreateTaskListener listener) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealm(task);
            realm.commitTransaction();
            listener.onCreateTaskSuccess();
        } finally {
            realm.close();
        }
    }

    @Override
    public void makeWebPetition(String fruit, String peaches, final OnAdminListener listener) {
        Call<List<Farmer>> call =webService.getWebService(fruit,peaches);
        call.enqueue(new Callback<List<Farmer>>() {
            @Override
            public void onResponse(Call<List<Farmer>> call, Response<List<Farmer>> response) {
                if(response.isSuccessful()){
                    listener.onAdminSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Farmer>> call, Throwable t) {

            }
        });

    }
}

package com.erikmedina.taskmanager.domain.service;

import com.erikmedina.taskmanager.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by erik on 17/12/16.
 */

public class ServiceManager {

    public static WebService createWebService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(WebService.class);
    }
}

package com.erikmedina.taskmanager.domain.service;

import com.erikmedina.taskmanager.domain.entity.Farm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by erik on 19/12/16.
 */

public interface WebService {

    @Headers("Accept:application/json")
    @GET(".")
    Call<List<Farm>> getWebService(@Query("category") String category,
                                   @Query("item") String item);
}

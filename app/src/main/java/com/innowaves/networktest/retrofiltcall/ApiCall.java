package com.innowaves.networktest.retrofiltcall;

import com.innowaves.networktest.StationListBackend;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by sics on 11/20/2015.
 */
public interface ApiCall {

    @GET("/stations.php")
    public void getDetails(@Query("userId") String userid, Callback<StationListBackend> response);
}

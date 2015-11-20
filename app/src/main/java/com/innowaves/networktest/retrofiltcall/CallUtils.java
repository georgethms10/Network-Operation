package com.innowaves.networktest.retrofiltcall;

import com.innowaves.networktest.MainActivity;

import retrofit.RestAdapter;

/**
 * Created by sics on 11/20/2015.
 */
public class CallUtils {


    public static ApiCall getRet() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(MainActivity.API).build();
        ApiCall call = restAdapter.create(ApiCall.class);
        return call;
    }


}

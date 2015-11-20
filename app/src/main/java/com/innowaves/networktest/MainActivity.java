package com.innowaves.networktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.innowaves.networktest.asychttpclientcall.AsycHttpCall;
import com.innowaves.networktest.asychttpclientcall.Response;
import com.innowaves.networktest.retrofiltcall.CallUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;

public class MainActivity extends AppCompatActivity implements Response {

    @Bind(R.id.button_async)
    Button button;
    @Bind(R.id.button_retrofit)
    Button button2;


    public static final int ASYNC_CODE = 100;
    public static final int RETROFIT_CODE = 200;

    long start;
    long end;

    public static String API = "http://sicsglobal.com/projects/App_projects/VergeFM";
    @Bind(R.id.response_time)
    TextView responseTime;

    @Bind(R.id.retro_response_time)
    TextView retroresponseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    /**
     * Network call using ASYNC_HTTP
     */
    @OnClick(R.id.button_async)
    public void asycServerCall() {

        start = System.currentTimeMillis();
        AsycHttpCall.getInstance().CallApi(API + "/stations.php?userId=71", ASYNC_CODE, this);
    }

    /**
     * Network call using RETROFIT
     */
    @OnClick(R.id.button_retrofit)
    public void retrofitCall() {
        callRetrofit("71");
    }


    @Override
    public void onSuccess(String response, int code) {

        StationListBackend details=(new Gson()).fromJson(response,StationListBackend.class);

        end=System.currentTimeMillis();

        responseTime.setText(String.valueOf(end-start)+"ms");

        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onFail(String response, int code) {
        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
    }


    public void callRetrofit(String uid)
    {
        final long start = System.currentTimeMillis();
        CallUtils.getRet().getDetails(uid, new Callback<StationListBackend>() {
            @Override
            public void success(StationListBackend stationListBackend, retrofit.client.Response response) {

                long end = System.currentTimeMillis();
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                retroresponseTime.setText(String.valueOf(end-start)+"ms");
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}

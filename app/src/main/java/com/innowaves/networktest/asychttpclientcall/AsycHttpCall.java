package com.innowaves.networktest.asychttpclientcall;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by sics on 11/20/2015.
 */
public class AsycHttpCall {

    private static AsycHttpCall instance;

    public static AsycHttpCall getInstance() {
        if (instance == null)
            instance = new AsycHttpCall();

        return instance;
    }

    public void CallApi(String url2, final int code, final Response resp) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.setConnectTimeout(30000);
        client.get(url2, new AsyncHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                try {
                    System.out.println("response code " + responseBody);

                    String responsebodys = new String(responseBody);
                    System.out.println("response is " + responsebodys);
                    resp.onSuccess(responsebodys, code);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                try {


                    System.out.println("response is " + responseBody.toString());
                    resp.onFail(responseBody.toString(), code);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
